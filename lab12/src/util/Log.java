package util;

/** Єдиний журнал подій у форматі [час] [джерело] подія. Час умовний: стартує о 08:00:00. */
public final class Log {
    private static int seconds = 8 * 3600;

    private Log() {
    }

    public static void log(String source, String event) {
        seconds += 7;
        System.out.printf("[%02d:%02d:%02d] [%s] %s%n",
                seconds / 3600, seconds / 60 % 60, seconds % 60, source, event);
    }
}
