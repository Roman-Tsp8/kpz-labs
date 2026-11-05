package rental;

/** ConcreteCreator. */
public class HourlyRental extends RentalProcess {
    @Override
    protected Trip createTrip() { return new HourlyTrip(); }
}
