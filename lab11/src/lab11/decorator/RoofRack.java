package lab11.decorator;

/** ConcreteDecorator: багажник на дах. */
public class RoofRack extends TripOption {
    public RoofRack(Trip inner) {
        super(inner);
    }

    @Override
    protected String optionName() {
        return "багажник на дах";
    }

    @Override
    protected double surcharge() {
        return 0.70;
    }
}
