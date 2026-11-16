package lab11.facade;

import lab11.common.Log;

/** Підсистема: резервування авто. */
public class CarReservationService {
    public void reserve(String carId, String driverId) {
        Log.log("CarReservationService", "авто " + carId + " зарезервовано за водієм " + driverId);
    }
}
