package ua.miskauto.command;

import ua.miskauto.log.EventLog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Invoker: диспетчерський центр. Виконує команди для авто на зв'язку,
 * накопичує команди для авто поза зв'язком, веде історію (для undo) і журнал.
 */
public class CommandCenter {
    private static final String SRC = "CommandCenter";

    private final Queue<CarCommand> pending = new LinkedList<>(); // черга (хто перший надіслав )
    private final Deque<CarCommand> history = new ArrayDeque<>(); // стек (для скасування команди (остання виконана))
    private final List<String> auditLog = new ArrayList<>();

    public void send(CarCommand command) {
        EventLog.log(SRC, "отримано команду: " + command.description());
        if (command.getCar().isOnline()) {
            run(command); // авто онлайн ?(так) (одразу виконуємо команду )
        } else {
            pending.add(command);
            EventLog.log(SRC, "авто " + command.getCar().getPlate()
                    + " поза зв'язком → команду поставлено в чергу (у черзі: " + pending.size() + ")");
        } // авто онлайн ? (ні) в чергу
    }

    /** Викликається, коли авто знову на зв'язку: виконує накопичені команди цього авто у порядку надходження. */
    public void onCarReconnected(Car car) {
        EventLog.log(SRC, "авто " + car.getPlate() + " на зв'язку → виконую відкладені команди");
        int n = pending.size();
        for (int i = 0; i < n; i++) {
            CarCommand c = pending.poll();
            if (c.getCar() == car) {
                run(c);
            } else {
                pending.add(c); // чужі команди лишаються в черзі
            }
        }
    }

    public void undoLast() {
        CarCommand c = history.pollFirst();
        if (c == null) {
            EventLog.log(SRC, "скасування неможливе: історія порожня");
            return;
        }
        EventLog.log(SRC, "скасовую: " + c.description());
        c.undo();
        auditLog.add("СКАСОВАНО: " + c.description());
    }

    private void run(CarCommand c) {
        EventLog.log(SRC, "виконую: " + c.description());
        c.execute();
        history.addFirst(c);
        auditLog.add("ВИКОНАНО: " + c.description());
    }

    public int pendingCount() { return pending.size(); }  // показує скільки авто ще в черзі

    /** Журнал безпеки: усі виконані та скасовані команди. */
    public void printAuditLog() {
        EventLog.log(SRC, "журнал команд (служба безпеки), записів: " + auditLog.size());
        int i = 1;
        for (String line : auditLog) {
            System.out.println("    " + (i++) + ". " + line);
        }
    }
}
