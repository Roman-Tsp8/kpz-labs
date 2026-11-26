package com.miskavto.lab15.template;

public class PetrolCarInspection extends CarInspection {
    private static final int MIN_FUEL = 20;

    public PetrolCarInspection(String plate, int fuelLevel) {
        super(plate, fuelLevel);
    }

    @Override protected String typeName() { return "бензинове авто"; }

    @Override protected boolean checkEnergy() {
        boolean ok = energyLevel >= MIN_FUEL;
        log("Перевірка пального: " + energyLevel + "% → " + (ok ? "достатньо" : "замало"));
        return ok;
    }

    @Override protected void technicalCheck() {
        log("Технічна перевірка: двигун, рівень масла, гальмівна система");
    }
}
