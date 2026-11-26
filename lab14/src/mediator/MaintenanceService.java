package mediator;

/** ConcreteColleague: служба обслуговування. */
public class MaintenanceService extends DispatchService {

    public MaintenanceService(DispatchMediator mediator) {
        super(mediator, "MaintenanceService");
    }

    /** Ініціює подію: ремонт завершено. */
    public void completeRepair(String carId) {
        log("ремонт " + carId + " завершено");
        mediator.onServiceEvent(this, DispatchEvent.REPAIR_COMPLETED, carId);
    }

    /** Виконує наказ координатора. */
    public void acceptCar(String carId) {
        log(carId + " прийнято в сервіс на огляд і ремонт");
    }
}
