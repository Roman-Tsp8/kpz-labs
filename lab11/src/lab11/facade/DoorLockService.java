package lab11.facade;

import lab11.common.Log;

/** Підсистема: замки дверей. Доступна й окремо від фасаду (напр. для служби підтримки). */
public class DoorLockService {
    public void unlock(String carId) {
        Log.log("DoorLockService", "двері авто " + carId + " розблоковано");
    }
}
