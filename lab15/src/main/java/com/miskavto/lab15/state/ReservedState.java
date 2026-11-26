package com.miskavto.lab15.state;

import com.miskavto.lab15.common.Log;

public class ReservedState extends CarState {
    private static final int BOOKING_TIMEOUT_MIN = 20;
    private final int bookedAt;

    public ReservedState(int bookedAt) { this.bookedAt = bookedAt; }

    @Override public String getName() { return "Заброньоване"; }

    @Override public void unlock(Car car, String customer) {
        if (customer.equals(car.getCustomer())) {
            car.log("Авто відкрито клієнтом " + customer + ", поїздка починається");
            car.setState(new InTripState());
        } else {
            car.log("Відмова: авто заброньоване іншим клієнтом, " + customer + " відкрити його не може");
        }
    }

    @Override public void onTimeElapsed(Car car) {
        if (Log.now() - bookedAt >= BOOKING_TIMEOUT_MIN) {
            car.log("Бронювання не підтверджено за " + BOOKING_TIMEOUT_MIN + " хв, скасовано автоматично");
            car.setCustomer(null);
            car.setState(new AvailableState());
        }
    }
}
