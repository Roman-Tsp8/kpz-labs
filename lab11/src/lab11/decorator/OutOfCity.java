package lab11.decorator;

/** ConcreteDecorator: поїздка за межі міста. */
public class OutOfCity extends TripOption {
    public OutOfCity(Trip inner) {
        super(inner);
    }

    @Override
    protected String optionName() {
        return "поїздка за межі міста";
    }

    @Override
    protected double surcharge() {
        return 2.00;
    }
}
