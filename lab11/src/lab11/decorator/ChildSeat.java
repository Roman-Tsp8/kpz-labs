package lab11.decorator;

/** ConcreteDecorator: дитяче крісло. */
public class ChildSeat extends TripOption {
    public ChildSeat(Trip inner) {
        super(inner);
    }

    @Override
    protected String optionName() {
        return "дитяче крісло";
    }

    @Override
    protected double surcharge() {
        return 0.50;
    }
}
