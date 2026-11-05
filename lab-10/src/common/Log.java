package common;

import java.time.LocalTime;

/** Єдиний журнал подій у форматі [час] [джерело] подія. Час умовний. */
public final class Log {
    private static int tick = 0;

    private Log() { }

    public static void log(String source, String event) {
        System.out.printf("[%s] [%s] %s%n", LocalTime.of(9, 0).plusMinutes(tick++), source, event);
    }

    public static void section(String title) {
        System.out.println("\n===== " + title + " =====");
    }
}
