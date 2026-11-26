package com.miskavto.lab15.strategy;

public interface TariffStrategy {
    String getName();
    double calculate(int minutes, double km);
}
