package fleet;

import common.Log;
import java.util.List;

/** Client: працює лише з абстракціями, конкретних класів елементів не знає. */
public class FleetService {
    private static final String SRC = "FleetService";

    public void commission(String carPlate, VehicleKitFactory factory) {
        Log.log(SRC, "Введення в роботу авто " + carPlate + " (тип: " + factory.carType() + ")");
        TelematicsModule telematics = factory.createTelematics();
        EnergyCard card = factory.createEnergyCard();
        LevelSensor sensor = factory.createLevelSensor();

        List<KitElement> kit = List.of(telematics, card, sensor);
        for (KitElement e : kit) {
            Log.log(SRC, "  [" + e.carType() + "] " + e.describe());
        }
        boolean consistent = kit.stream().allMatch(e -> e.carType().equals(factory.carType()));
        Log.log(SRC, consistent
                ? "Усі елементи набору належать до одного типу: " + factory.carType()
                : "ПОМИЛКА: набір змішаний!");
    }
}
