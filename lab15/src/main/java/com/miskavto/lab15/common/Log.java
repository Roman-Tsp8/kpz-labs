package com.miskavto.lab15.common;

public final class Log {
    private static int minutes = 9 * 60; // умовний час, старт 09:00

    private Log() {}

    public static void advance(int m) { minutes += m; }

    public static int now() { return minutes; }

    public static void log(String source, String event) {
        System.out.printf("[%02d:%02d] [%s] %s%n", (minutes / 60) % 24, minutes % 60, source, event);
    }
}
