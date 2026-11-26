package com.miskavto.lab15.state;

public abstract class CarState {
    public abstract String getName();

    // За замовчуванням усі операції заборонені, стани перевизначають лише дозволені
    public void book(Car car, String customer) { refuse(car, "бронювання"); }
    public void unlock(Car car, String customer) { refuse(car, "відкриття"); }
    public void pause(Car car) { refuse(car, "пауза"); }
    public void endTrip(Car car) { refuse(car, "завершення поїздки"); }
    public void sendToMaintenance(Car car) { refuse(car, "відправлення на обслуговування"); }
    public void finishMaintenance(Car car) { refuse(car, "завершення обслуговування"); }
    public void onTimeElapsed(Car car) { /* за замовчуванням час на стан не впливає */ }

    protected void refuse(Car car, String operation) {
        car.log("Відмова: операція «" + operation + "» неможлива у стані «" + getName() + "»");
    }
}
