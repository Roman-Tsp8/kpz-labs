package common;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Єдиний журнал подій. Формат кожного рядка: [час] [джерело] подія.
 * Час умовний: кожен запис "минає" на 5 секунд.
 */
public final class EventLog {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final LocalTime START = LocalTime.of(10, 0, 0);
    private static LocalTime clock = START;

    private EventLog() {
    }

    public static void log(String source, String event) {
        System.out.printf("[%s] [%s] %s%n", clock.format(FORMAT), source, event);
        clock = clock.plusSeconds(5);
    }

    public static void header(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }

    public static void reset() {
        clock = START;
    }
}
