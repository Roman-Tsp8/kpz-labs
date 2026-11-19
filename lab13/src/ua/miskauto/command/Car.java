package ua.miskauto.command;

import ua.miskauto.log.EventLog;

/** Receiver: авто, над яким виконуються віддалені команди.(одержувач) */
public class Car {
    private final String plate;
    private boolean online = true;
    private boolean doorsLocked = true;
    private boolean alarmOn = false;
    private boolean engineBlocked = false;

    public Car(String plate) { this.plate = plate; }

    public String getPlate() { return plate; }
    public boolean isOnline() { return online; }
    public boolean isDoorsLocked() { return doorsLocked; }
    public boolean isAlarmOn() { return alarmOn; }
    public boolean isEngineBlocked() { return engineBlocked; }

    public void setOnline(boolean online) {
        this.online = online;
        EventLog.log("Car " + plate, online ? "з'явилося на зв'язку" : "втратило зв'язок");
    }

    public void setDoorsLocked(boolean v) {
        doorsLocked = v;
        EventLog.log("Car " + plate, v ? "двері закрито" : "двері відкрито");
    }

    public void setAlarmOn(boolean v) {
        alarmOn = v;
        EventLog.log("Car " + plate, v ? "аварійну сигналізацію увімкнено" : "аварійну сигналізацію вимкнено");
    }

    public void setEngineBlocked(boolean v) {
        engineBlocked = v;
        EventLog.log("Car " + plate, v ? "двигун заблоковано" : "двигун розблоковано");
    }

    @Override
    public String toString() {
        return "двері=" + (doorsLocked ? "закриті" : "відкриті")
                + ", сигналізація=" + (alarmOn ? "увімк." : "вимк.")
                + ", двигун=" + (engineBlocked ? "заблокований" : "вільний");
    }
}
