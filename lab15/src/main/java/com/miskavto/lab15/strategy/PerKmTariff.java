package com.miskavto.lab15.strategy;

public class PerKmTariff implements TariffStrategy {
    private static final double RATE_PER_KM = 12.0;

    @Override public String getName() { return "Кілометровий"; }

    @Override public double calculate(int minutes, double km) {
        return km * RATE_PER_KM;
    }
}
