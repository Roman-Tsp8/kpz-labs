package com.miskavto.lab15.template;

public class ElectricCarInspection extends CarInspection {
    private static final int MIN_CHARGE = 20;

    public ElectricCarInspection(String plate, int chargeLevel) {
        super(plate, chargeLevel);
    }

    @Override protected String typeName() { return "електромобіль"; }

    @Override protected boolean checkEnergy() {
        boolean ok = energyLevel >= MIN_CHARGE;
        log("Перевірка заряду: " + energyLevel + "% → " + (ok ? "достатньо" : "замало"));
        return ok;
    }

    @Override protected void technicalCheck() {
        log("Технічна перевірка: тягова батарея, зарядний порт, високовольтні кабелі");
    }

    @Override protected void handleLowEnergy() {
        log("Низький заряд: авто відправлено на зарядку замість повернення в доступні");
    }
}
