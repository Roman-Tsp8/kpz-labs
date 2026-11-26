package com.miskavto.lab15.template;

public class GasCarInspection extends CarInspection {
    private static final int MIN_GAS = 20;

    public GasCarInspection(String plate, int gasLevel) {
        super(plate, gasLevel);
    }

    @Override protected String typeName() { return "авто на газу"; }

    @Override protected boolean checkEnergy() {
        boolean ok = energyLevel >= MIN_GAS;
        log("Перевірка газу в балоні: " + energyLevel + "% → " + (ok ? "достатньо" : "замало"));
        return ok;
    }

    @Override protected void technicalCheck() {
        log("Технічна перевірка: герметичність газової системи, редуктор, балон");
    }

    @Override protected void handleLowEnergy() {
        log("Мало газу: авто відправлено на ГЗС замість повернення в доступні");
    }
}
