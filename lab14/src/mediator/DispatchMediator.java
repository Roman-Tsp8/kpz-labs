package mediator;

/** Mediator: єдина точка, через яку служби повідомляють про свої дії. */
public interface DispatchMediator {

    void onServiceEvent(DispatchService sender, DispatchEvent event, String carId);
}
