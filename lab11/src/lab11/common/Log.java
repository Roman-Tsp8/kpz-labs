package lab11.common;

/** Консольний журнал подій у форматі [час] [джерело] подія. Час умовний (+1 с за кожну подію). */
public final class Log {
    private static int seconds = 10 * 3600; // умовний початок: 10:00:00

    private Log() {
    }

    public static void log(String source, String event) {
        seconds++;
        System.out.printf("[%02d:%02d:%02d] [%s] %s%n",
                (seconds / 3600) % 24, (seconds / 60) % 60, seconds % 60, source, event);
    }

    public static void section(String title) {
        System.out.println();
        System.out.println("===== " + title + " =====");
    }
}
