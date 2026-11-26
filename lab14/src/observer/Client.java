package observer;

import common.EventLog;

/** ConcreteObserver: клієнт каршерингу. Підписаний лише на час поїздки. */
public class Client implements CarEventListener {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Client " + name;
    }

    public void startTrip(Car car) {
        EventLog.log(getName(), "починає поїздку на " + car.getId() + " і підписується на події авто");
        car.subscribe(this);
    }

    public void endTrip(Car car) {
        EventLog.log(getName(), "завершує поїздку на " + car.getId() + " і відписується");
        car.unsubscribe(this);
    }

    @Override
    public void onCarEvent(CarEvent event) {
        switch (event.type()) {
            case LOW_BATTERY -> EventLog.log(getName(),
                    "отримав push: " + event.details() + ", знайдіть зарядну станцію");
            case OUT_OF_ZONE -> EventLog.log(getName(),
                    "отримав попередження: поверніться в зону обслуговування");
            case TRIP_FINISHED -> EventLog.log(getName(),
                    "отримав чек за поїздку на " + event.carId());
            default -> { /* інші події клієнта не цікавлять */ }
        }
    }
}
