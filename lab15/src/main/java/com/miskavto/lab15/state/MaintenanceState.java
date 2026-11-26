package com.miskavto.lab15.state;

public class MaintenanceState extends CarState {
    @Override public String getName() { return "На обслуговуванні"; }

    @Override public void book(Car car, String customer) {
        car.log("Відмова: авто на обслуговуванні, бронювання для " + customer + " неможливе");
    }

    @Override public void finishMaintenance(Car car) {
        car.setState(new AvailableState());
    }
}
