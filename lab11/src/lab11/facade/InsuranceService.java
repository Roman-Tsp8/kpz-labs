package lab11.facade;

import lab11.common.Log;

/** Підсистема: страхування поїздки. */
public class InsuranceService {
    public void insureTrip(String driverId, String carId) {
        Log.log("InsuranceService", "поїздку водія " + driverId + " на авто " + carId + " застраховано");
    }
}
