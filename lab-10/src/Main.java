import booking.*;
import common.Log;
import fleet.*;
import rental.*;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        task1AbstractFactory();
        task2FactoryMethod();
        task3Builder();
    }

    static void task1AbstractFactory() {
        Log.section("Завдання 1: Abstract Factory — набори елементів для авто");
        FleetService fleet = new FleetService();
        fleet.commission("AA1111AA", new PetrolKitFactory());
        fleet.commission("AA2222AA", new HybridKitFactory());
        fleet.commission("AA3333AA", new ElectricKitFactory());
        Log.log("Demo", "Додано тип «авто на газу» (новий GasKitFactory), FleetService не змінювався");
        fleet.commission("AA4444AA", new GasKitFactory());
    }

    static void task2FactoryMethod() {
        Log.section("Завдання 2: Factory Method — види оренди");
        Duration threeHours = Duration.ofHours(3);
        new MinuteRental().rent("AA1111AA", "Коваленко", threeHours);
        new HourlyRental().rent("AA1111AA", "Коваленко", threeHours);
        new DailyRental().rent("AA1111AA", "Коваленко", threeHours);
        Log.log("Demo", "Додано оренду «вихідні» (WeekendRental + WeekendTrip), RentalProcess не змінювався");
        new WeekendRental().rent("AA1111AA", "Коваленко", threeHours);
    }

    static void task3Builder() {
        Log.section("Завдання 3: Builder — бронювання авто");
        Clock clock = Clock.fixed(Instant.parse("2026-11-04T09:00:00Z"), ZoneOffset.UTC);
        LocalDateTime tomorrow = LocalDateTime.now(clock).plusDays(1);

        // 1. Бронювання з дитячим кріслом і подачею до адреси
        Booking b1 = new BookingBuilder(clock)
                .client("Коваленко").car("Renault Zoe AA3333AA").startTime(tomorrow)
                .withChildSeat().deliveredTo("вул. Городоцька, 15")
                .build();
        System.out.println(b1);

        // 2. Типове бронювання «Аеропорт»
        Booking b2 = new BookingDirector().airport(new BookingBuilder(clock),
                "Шевченко", "Toyota Prius AA2222AA", tomorrow);
        System.out.println(b2);

        // 3. Без авто
        try {
            new BookingBuilder(clock).client("Мельник").startTime(tomorrow).build();
        } catch (BookingException e) {
            Log.log("Demo", "Перехоплено: " + e.getMessage());
        }
    }
}
