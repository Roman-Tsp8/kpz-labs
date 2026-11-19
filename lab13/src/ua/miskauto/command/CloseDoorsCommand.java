package ua.miskauto.command;

/** ConcreteCommand: закрити двері. */
public class CloseDoorsCommand extends CarCommand {
    private boolean previous;

    public CloseDoorsCommand(Car car, String sender) { super(car, sender); }

    @Override public void execute() { previous = car.isDoorsLocked(); car.setDoorsLocked(true); }
    @Override public void undo() { car.setDoorsLocked(previous); }
    @Override protected String name() { return "Закрити двері"; }
}
