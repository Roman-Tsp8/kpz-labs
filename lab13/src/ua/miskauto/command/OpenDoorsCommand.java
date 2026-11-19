package ua.miskauto.command;

/** ConcreteCommand: відкрити двері. */
public class OpenDoorsCommand extends CarCommand {
    private boolean previous;

    public OpenDoorsCommand(Car car, String sender) { super(car, sender); }

    @Override public void execute() { previous = car.isDoorsLocked(); car.setDoorsLocked(false); }
    @Override public void undo() { car.setDoorsLocked(previous); }
    @Override protected String name() { return "Відкрити двері"; }
}
