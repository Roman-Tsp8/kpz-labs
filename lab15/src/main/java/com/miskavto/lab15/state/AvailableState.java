package com.miskavto.lab15.state;

import com.miskavto.lab15.common.Log;

public class AvailableState extends CarState {
    @Override public String getName() { return "Доступне"; }

    @Override public void book(Car car, String customer) {
        car.setCustomer(customer);
        car.log("Бронювання для клієнта " + customer + " (діє 20 хв)");
        car.setState(new ReservedState(Log.now()));
    }

    @Override public void sendToMaintenance(Car car) {
        car.setState(new MaintenanceState());
    }
}
