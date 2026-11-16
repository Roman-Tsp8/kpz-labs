package lab11.facade;

import lab11.common.Log;

/** Підсистема: телематика авто. */
public class TelematicsService {
    public void enable(String carId) {
        Log.log("TelematicsService", "телематику авто " + carId + " увімкнено");
    }
}
