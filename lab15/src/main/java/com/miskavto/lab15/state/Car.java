package com.miskavto.lab15.state;

import com.miskavto.lab15.common.Log;

public class Car {
    private final String plate;
    private CarState state;
    private String customer;

    public Car(String plate) {
        this.plate = plate;
        this.state = new AvailableState();
        log("Авто створено у стані «" + state.getName() + "»");
    }

    // Делегування поточному стану, жодних розгалужень за статусом
    public void book(String customer) { state.book(this, customer); }
    public void unlock(String customer) { state.unlock(this, customer); }
    public void pause() { state.pause(this); }
    public void endTrip() { state.endTrip(this); }
    public void sendToMaintenance() { state.sendToMaintenance(this); }
    public void finishMaintenance() { state.finishMaintenance(this); }

    public void advanceTime(int minutes) {
        Log.advance(minutes);
        log("Минуло " + minutes + " хв");
        state.onTimeElapsed(this);
    }

    void setState(CarState newState) {
        log("Перехід: «" + state.getName() + "» → «" + newState.getName() + "»");
        this.state = newState;
    }

    String getCustomer() { return customer; }
    void setCustomer(String customer) { this.customer = customer; }

    public void log(String event) { Log.log("Car:" + plate, event); }
}
