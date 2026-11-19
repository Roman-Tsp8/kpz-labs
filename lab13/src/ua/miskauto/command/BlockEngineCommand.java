package ua.miskauto.command;

/** ConcreteCommand: заблокувати двигун. */
public class BlockEngineCommand extends CarCommand {
    private boolean previous;

    public BlockEngineCommand(Car car, String sender) { super(car, sender); }

    @Override public void execute() { previous = car.isEngineBlocked(); car.setEngineBlocked(true); }
    @Override public void undo() { car.setEngineBlocked(previous); }
    @Override protected String name() { return "Заблокувати двигун"; }
}
