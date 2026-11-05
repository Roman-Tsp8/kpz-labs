package rental;

/** ConcreteCreator. */
public class DailyRental extends RentalProcess {
    @Override
    protected Trip createTrip() { return new DailyTrip(); }
}
