package lab11.facade;

import lab11.common.Log;

/** Клієнт фасаду: мобільний застосунок. З підсистемами напряму не працює. */
public class MobileApp {
    private final TripFacade facade;

    public MobileApp(TripFacade facade) {
        this.facade = facade;
    }

    public void pressStart(String driverId, String carId) {
        Log.log("MobileApp", "користувач " + driverId + " натиснув «Почати поїздку»");
        facade.startTrip(driverId, carId);
    }
}
