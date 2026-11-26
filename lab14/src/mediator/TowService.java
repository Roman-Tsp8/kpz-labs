package mediator;

/** ConcreteColleague: служба евакуації. */
public class TowService extends DispatchService {

    public TowService(DispatchMediator mediator) {
        super(mediator, "TowService");
    }

    /** Виконує наказ координатора. */
    public void dispatchTow(String carId) {
        log("евакуатор виїхав до " + carId);
    }

    /** Ініціює подію: авто доставлено. */
    public void completeEvacuation(String carId) {
        log(carId + " доставлено на стоянку");
        mediator.onServiceEvent(this, DispatchEvent.EVACUATION_COMPLETED, carId);
    }
}
