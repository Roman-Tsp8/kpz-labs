package lab11.decorator;

/** ConcreteDecorator: повне страхування. */
public class FullInsurance extends TripOption {
    public FullInsurance(Trip inner) {
        super(inner);
    }

    @Override
    protected String optionName() {
        return "повне страхування";
    }

    @Override
    protected double surcharge() {
        return 1.50;
    }
}
