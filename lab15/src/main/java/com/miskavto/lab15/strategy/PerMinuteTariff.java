package com.miskavto.lab15.strategy;

public class PerMinuteTariff implements TariffStrategy {
    private static final double RATE_PER_MINUTE = 5.0;

    @Override public String getName() { return "Поминутний"; }

    @Override public double calculate(int minutes, double km) {
        return minutes * RATE_PER_MINUTE;
    }
}
