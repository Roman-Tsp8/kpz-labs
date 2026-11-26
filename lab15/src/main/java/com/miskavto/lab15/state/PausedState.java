package com.miskavto.lab15.state;

public class PausedState extends CarState {
    @Override public String getName() { return "На паузі"; }

    @Override public void unlock(Car car, String customer) {
        if (customer.equals(car.getCustomer())) {
            car.log("Клієнт " + customer + " відкрив авто, поїздка продовжується");
            car.setState(new InTripState());
        } else {
            car.log("Відмова: авто на паузі за іншим клієнтом, " + customer + " відкрити його не може");
        }
    }
}
