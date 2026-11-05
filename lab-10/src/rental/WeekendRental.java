package rental;

/** ConcreteCreator. */
public class WeekendRental extends RentalProcess {
    @Override
    protected Trip createTrip() { return new WeekendTrip(); }
}
