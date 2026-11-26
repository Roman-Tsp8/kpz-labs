package com.miskavto.lab15.template;

public class HybridCarInspection extends CarInspection {
    private static final int MIN_LEVEL = 15;
    private final int batteryLevel;

    public HybridCarInspection(String plate, int fuelLevel, int batteryLevel) {
        super(plate, fuelLevel);
        this.batteryLevel = batteryLevel;
    }

    @Override protected String typeName() { return "гібрид"; }

    @Override protected boolean checkEnergy() {
        boolean ok = energyLevel >= MIN_LEVEL || batteryLevel >= MIN_LEVEL;
        log("Перевірка енергії: пальне " + energyLevel + "%, батарея " + batteryLevel
                + "% → " + (ok ? "достатньо" : "замало"));
        return ok;
    }

    @Override protected void technicalCheck() {
        log("Технічна перевірка: ДВЗ, тягова батарея, система рекуперації");
    }

    @Override protected void wash() {
        log("Мийка: експрес-мийка кузова");
    }
}
