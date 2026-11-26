package mediator;

/** ConcreteColleague: служба підтримки. */
public class SupportService extends DispatchService {

    public SupportService(DispatchMediator mediator) {
        super(mediator, "SupportService");
    }

    /** Виконує наказ координатора. */
    public void openCase(String carId, String reason) {
        log("створено звернення по " + carId + " (" + reason + "), оператор зв'язується з клієнтом");
    }
}
