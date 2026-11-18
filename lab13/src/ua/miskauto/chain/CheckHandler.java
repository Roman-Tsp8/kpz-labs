package ua.miskauto.chain;

import ua.miskauto.log.EventLog;

/**
 * Handler: базова ланка ланцюга перевірок (Template Method).
 * Ланка або зупиняє клієнта з причиною, або передає запит далі.
 */
public abstract class CheckHandler {
    private CheckHandler next;

    public CheckHandler setNext(CheckHandler next) {
        this.next = next;
        return next; // для fluent-збирання: a.setNext(b).setNext(c)
    }

    public final CheckResult handle(TripRequest request) {
        EventLog.log(name(), "отримано запит " + request);
        String failure = check(request);
        if (failure != null) {
            EventLog.log(name(), "ВІДМОВА: " + failure);
            return CheckResult.rejected(failure, name());
        }
        if (next == null) {
            EventLog.log(name(), "перевірку пройдено, ланцюг завершено → допуск надано");
            return CheckResult.approved(name());
        }
        EventLog.log(name(), "перевірку пройдено → передаю далі: " + next.name());
        return next.handle(request);
    }

    /** @return причина відмови або null, якщо перевірку пройдено. */
    protected abstract String check(TripRequest request);

    public abstract String name();
}
