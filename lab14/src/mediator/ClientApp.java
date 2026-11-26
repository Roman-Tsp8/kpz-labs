package mediator;

/** ConcreteColleague: застосунок клієнта. */
public class ClientApp extends DispatchService {

    public ClientApp(DispatchMediator mediator) {
        super(mediator, "ClientApp");
    }

    /** Ініціює подію: клієнт повідомляє про ДТП. */
    public void reportAccident(String carId) {
        log("клієнт повідомляє про ДТП з " + carId);
        mediator.onServiceEvent(this, DispatchEvent.ACCIDENT_REPORTED, carId);
    }

    /** Виконує наказ координатора. */
    public void finishTrip(String carId) {
        log("поїздку на " + carId + " завершено, тарифікацію зупинено");
    }
}
