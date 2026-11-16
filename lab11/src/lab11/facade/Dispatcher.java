package lab11.facade;

import lab11.common.Log;

/** Клієнт фасаду: диспетчер. З підсистемами напряму не працює. */
public class Dispatcher {
    private final TripFacade facade;

    public Dispatcher(TripFacade facade) {
        this.facade = facade;
    }

    public void startTripForClient(String driverId, String carId) {
        Log.log("Dispatcher", "диспетчер починає поїздку для клієнта " + driverId);
        facade.startTrip(driverId, carId);
    }
}
