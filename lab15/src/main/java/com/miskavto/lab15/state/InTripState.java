package com.miskavto.lab15.state;

public class InTripState extends CarState {
    @Override public String getName() { return "В поїздці"; }

    @Override public void pause(Car car) {
        car.log("Клієнт " + car.getCustomer() + " залишив авто з продовженням оренди");
        car.setState(new PausedState());
    }

    @Override public void endTrip(Car car) {
        car.log("Поїздку клієнта " + car.getCustomer() + " завершено");
        car.setCustomer(null);
        car.setState(new AvailableState());
    }
}
