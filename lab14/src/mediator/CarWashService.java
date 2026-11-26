package mediator;

/** ConcreteColleague: мийка авто (нова служба, існуючі класи не змінювались). */
public class CarWashService extends DispatchService {

    public CarWashService(DispatchMediator mediator) {
        super(mediator, "CarWashService");
    }

    /** Виконує наказ координатора, після чого повідомляє про завершення. */
    public void washCar(String carId) {
        log(carId + " прийнято на мийку");
        log(carId + " помито");
        mediator.onServiceEvent(this, DispatchEvent.WASH_COMPLETED, carId);
    }
}
