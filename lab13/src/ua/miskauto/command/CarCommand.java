package ua.miskauto.command;

/** Спільна база конкретних команд: зберігає авто та відправника. */
public abstract class CarCommand implements RemoteCommand {
    protected final Car car;
    private final String sender;

    protected CarCommand(Car car, String sender) {
        this.car = car;
        this.sender = sender;
    }

    public Car getCar() { return car; }

    @Override
    public String description() {
        return name() + " (від: " + sender + ", авто " + car.getPlate() + ")";
    }

    protected abstract String name();
}
