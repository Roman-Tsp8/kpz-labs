package observer;

import common.EventLog;

/** ConcreteObserver: служба обслуговування парку. */
public class FleetService implements CarEventListener {

    @Override
    public String getName() {
        return "FleetService";
    }

    @Override
    public void onCarEvent(CarEvent event) {
        switch (event.type()) {
            case LOW_BATTERY -> EventLog.log(getName(),
                    event.carId() + ": " + event.details() + ", ставлю авто в чергу на зарядку");
            case OUT_OF_ZONE -> EventLog.log(getName(),
                    event.carId() + ": фіксую виїзд за межі зони");
            case TRIP_FINISHED -> EventLog.log(getName(),
                    event.carId() + ": планую огляд і прибирання салону");
            default -> { /* ДТП обробляють диспетчер і страхова */ }
        }
    }
}
