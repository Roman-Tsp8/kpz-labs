package com.miskavto.lab15.template;

import com.miskavto.lab15.common.Log;

public abstract class CarInspection {
    protected final String plate;
    protected final int energyLevel;

    protected CarInspection(String plate, int energyLevel) {
        this.plate = plate;
        this.energyLevel = energyLevel;
    }

    // Шаблонний метод: послідовність етапів зафіксована тут і final
    public final void inspect() {
        log("Початок огляду: " + typeName());
        exteriorInspection();
        interiorCheck();
        boolean energyOk = checkEnergy();
        technicalCheck();
        wash();
        if (energyOk) {
            returnToAvailable();
        } else {
            handleLowEnergy();
        }
        log("Огляд завершено");
    }

    // Спільні етапи: однакові для всіх, перевизначити не можна
    protected final void exteriorInspection() {
        log("Зовнішній огляд: кузов, скло, колеса, номерні знаки");
    }

    protected final void interiorCheck() {
        log("Перевірка салону: чистота, речі клієнта, стан сидінь");
    }

    protected final void returnToAvailable() {
        log("Авто повернуто в парк: статус «Доступне»");
    }

    // Етапи, що різняться, підклас зобов'язаний їх реалізувати
    protected abstract String typeName();
    protected abstract boolean checkEnergy();
    protected abstract void technicalCheck();

    // Необов'язкові етапи (hook) зі значенням за замовчуванням
    protected void wash() {
        log("Мийка: не потрібна, етап пропущено");
    }

    protected void handleLowEnergy() {
        log("Низький рівень енергії: авто відправлено на заправку замість повернення в доступні");
    }

    protected final void log(String event) {
        Log.log("Inspection:" + plate, event);
    }
}
