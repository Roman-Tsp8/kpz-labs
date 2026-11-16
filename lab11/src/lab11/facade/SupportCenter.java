package lab11.facade;

import lab11.common.Log;

/** Служба підтримки: користується підсистемою замків окремо, без початку поїздки. */
public class SupportCenter {
    private final DoorLockService doorLock;

    public SupportCenter(DoorLockService doorLock) {
        this.doorLock = doorLock;
    }

    public void remoteUnlock(String carId) {
        Log.log("SupportCenter", "віддалене розблокування дверей за запитом клієнта");
        doorLock.unlock(carId);
    }
}
