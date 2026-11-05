package rental;

/** ConcreteCreator. */
public class MinuteRental extends RentalProcess {
    @Override
    protected Trip createTrip() { return new MinuteTrip(); }
}
