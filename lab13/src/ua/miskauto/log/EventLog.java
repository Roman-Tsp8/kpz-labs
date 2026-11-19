package ua.miskauto.log;

/** Консольний журнал подій у форматі [час] [джерело] подія. Час умовний: +1 с на кожну подію. */
public final class EventLog {
    private static int seconds = 10 * 3600; // 10:00:00

    private EventLog() { }

    public static void log(String source, String event) {
        int h = seconds / 3600, m = seconds / 60 % 60, s = seconds % 60;
        System.out.printf("[%02d:%02d:%02d] [%s] %s%n", h, m, s, source, event);
        seconds++;
    }

    public static void section(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
