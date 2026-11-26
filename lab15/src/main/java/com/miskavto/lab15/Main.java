package com.miskavto.lab15;

import com.miskavto.lab15.strategy.*;
import com.miskavto.lab15.state.Car;
import com.miskavto.lab15.template.*;

public class Main {
    public static void main(String[] args) {
        section("Завдання 1. Strategy: вартість поїздки");
        demoTariffs();
        section("Завдання 2. Template Method: огляд авто");
        demoInspection();
        section("Завдання 3. State: стан авто");
        demoCarStates();
    }

    private static void demoTariffs() {
        Trip trip = new Trip("Олена", 40, 18, false, new PerMinuteTariff());
        trip.calculateCost();
        trip.setTariff(new PerKmTariff());
        trip.calculateCost();
        trip.setTariff(new CombinedTariff());
        trip.calculateCost();

        trip.setTariff(new CorporateFixedTariff());
        trip.calculateCost();

        trip.setTariff(new NightTariff());
        trip.calculateCost();

        Trip peak = new Trip("Андрій", 40, 18, true, new CombinedTariff());
        peak.calculateCost();
    }

    private static void demoInspection() {
        new PetrolCarInspection("AA1234", 60).inspect();
        System.out.println();
        new ElectricCarInspection("BC5678", 15).inspect();
        System.out.println();
        new GasCarInspection("KA9012", 70).inspect();
    }

    private static void demoCarStates() {
        Car car = new Car("AA1234");
        car.book("Олена");
        car.book("Петро");            // відмова: уже заброньоване
        car.unlock("Петро");          // відмова: чужий клієнт
        car.unlock("Олена");
        car.advanceTime(25);
        car.pause();
        car.advanceTime(10);
        car.unlock("Олена");
        car.advanceTime(15);
        car.endTrip();
        car.endTrip();                // відмова: авто вже доступне

        System.out.println();
        Car car2 = new Car("BC5678");
        car2.book("Іван");
        car2.advanceTime(20);         // автоскасування бронювання

        System.out.println();
        Car car3 = new Car("KA9012");
        car3.sendToMaintenance();
        car3.book("Марія");           // відмова
    }

    private static void section(String title) {
        System.out.println("\n===== " + title + " =====");
    }
}
