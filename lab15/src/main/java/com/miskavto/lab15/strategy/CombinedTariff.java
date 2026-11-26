package com.miskavto.lab15.strategy;

public class CombinedTariff implements TariffStrategy {
    private static final double RATE_PER_MINUTE = 2.5;
    private static final double RATE_PER_KM = 7.0;

    @Override public String getName() { return "Комбінований"; }

    @Override public double calculate(int minutes, double km) {
        return minutes * RATE_PER_MINUTE + km * RATE_PER_KM;
    }
}
