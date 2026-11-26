package com.miskavto.lab15.strategy;

public class NightTariff implements TariffStrategy {
    private static final double RATE_PER_MINUTE = 3.5;
    private static final double RATE_PER_KM = 8.0;

    @Override public String getName() { return "Нічний"; }

    @Override public double calculate(int minutes, double km) {
        return minutes * RATE_PER_MINUTE + km * RATE_PER_KM;
    }
}
