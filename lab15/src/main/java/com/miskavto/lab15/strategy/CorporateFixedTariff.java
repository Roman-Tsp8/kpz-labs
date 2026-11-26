package com.miskavto.lab15.strategy;

public class CorporateFixedTariff implements TariffStrategy {
    private static final double FIXED_PRICE = 350.0;

    @Override public String getName() { return "Корпоративний (фіксований)"; }

    @Override public double calculate(int minutes, double km) {
        return FIXED_PRICE;
    }
}
