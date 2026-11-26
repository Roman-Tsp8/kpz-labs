package mediator;

import common.EventLog;

/**
 * Colleague: базовий клас усіх служб.
 * Знає лише посередника, а не інші служби.
 */
public abstract class DispatchService {
    protected final DispatchMediator mediator;
    private final String name;

    protected DispatchService(DispatchMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void log(String event) {
        EventLog.log(name, event);
    }
}
