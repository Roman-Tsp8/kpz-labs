package lab11.decorator;

/** ConcreteDecorator: другий водій. */
public class SecondDriver extends TripOption {
    public SecondDriver(Trip inner) {
        super(inner);
    }

    @Override
    protected String optionName() {
        return "другий водій";
    }

    @Override
    protected double surcharge() {
        return 0.80;
    }
}
