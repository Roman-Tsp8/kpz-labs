package ua.miskauto.command;

/** ConcreteCommand: увімкнути аварійну сигналізацію. */
public class AlarmCommand extends CarCommand {
    private boolean previous;

    public AlarmCommand(Car car, String sender) { super(car, sender); }

    @Override public void execute() { previous = car.isAlarmOn(); car.setAlarmOn(true); }
    @Override public void undo() { car.setAlarmOn(previous); }
    @Override protected String name() { return "Увімкнути аварійну сигналізацію"; }
}
