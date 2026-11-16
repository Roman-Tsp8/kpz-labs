package lab11.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lab11.common.Log;

/**
 * Protection Proxy: перевіряє, що команду віддає поточний орендар, і веде журнал команд.
 * У разі відмови до віддаленого сервера не звертається.
 */
public class CarAccessProxy implements CarCommands {
    private final String carId;
    private final CarCommands real;
    private final RentalRegistry registry;
    private final List<String> auditLog = new ArrayList<>();

    public CarAccessProxy(String carId, CarCommands real, RentalRegistry registry) {
        this.carId = carId;
        this.real = real;
        this.registry = registry;
    }

    public List<String> getAuditLog() {
        return Collections.unmodifiableList(auditLog);
    }

    @Override
    public void openDoors(String clientId) {
        if (allow("openDoors", clientId)) {
            real.openDoors(clientId);
        }
    }

    @Override
    public void startEngine(String clientId) {
        if (allow("startEngine", clientId)) {
            real.startEngine(clientId);
        }
    }

    @Override
    public void honk(String clientId) {
        if (allow("honk", clientId)) {
            real.honk(clientId);
        }
    }

    private boolean allow(String command, String clientId) {
        boolean ok = registry.renterOf(carId).filter(clientId::equals).isPresent();
        auditLog.add("авто " + carId + ", клієнт " + clientId + ": " + command
                + (ok ? " — дозволено" : " — відмова"));
        if (ok) {
            Log.log("CarAccessProxy", "перевірка пройдена: " + clientId + " — орендар авто " + carId
                    + ", передаю команду «" + command + "» далі");
        } else {
            Log.log("CarAccessProxy", "ВІДМОВА для клієнта " + clientId + ": Ви не є орендарем цього авто"
                    + " (сервер виробника не викликається)");
        }
        return ok;
    }
}
