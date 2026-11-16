package lab11.facade;

import lab11.common.Log;

/** Підсистема: перевірка посвідчення водія. */
public class DriverLicenseService {
    public boolean verify(String driverId) {
        Log.log("DriverLicenseService", "перевіряю посвідчення водія " + driverId + " — дійсне");
        return true;
    }
}
