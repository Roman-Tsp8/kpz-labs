import bridge.*;
import composite.*;
import flyweight.*;
import util.Log;

import java.util.Random;

/** Раннер: окремий метод для кожної ситуації. */
public class Main {
    public static void main(String[] args) {
        System.out.println("===== Завдання 1. Flyweight: авто на мапі міста =====");
        task1Flyweight();
        System.out.println("\n===== Завдання 2. Composite: зони міста і тарифікація =====");
        task2Composite();
        System.out.println("\n===== Завдання 3. Bridge: звіти для різних отримувачів =====");
        task3Bridge();
    }

    static void task1Flyweight() {
        String[] names = {"Renault Zoe", "Tesla Model 3", "Kia Niro EV", "Hyundai Kona"};
        int[] seats = {5, 5, 5, 5};
        int[] range = {300, 480, 385, 305};

        // Парк: 200 авто, кожне має одну з 4 моделей
        String[] plates = new String[200];
        CarModel[] carModel = new CarModel[200];
        for (int i = 0; i < 200; i++) {
            plates[i] = String.format("AA%04dKC", 1000 + i);
            int m = i % 4;
            carModel[i] = CarModelFactory.getModel(names[m], seats[m], range[m]);
        }

        Random rnd = new Random(42);
        int total = 100_000;
        RouteMarker[] markers = new RouteMarker[total];
        for (int i = 0; i < total; i++) {
            int car = rnd.nextInt(200);
            double lat = 50.40 + rnd.nextDouble() * 0.10;
            double lon = 30.45 + rnd.nextDouble() * 0.15;
            String time = String.format("%02d:%02d", rnd.nextInt(24), rnd.nextInt(60));
            markers[i] = new RouteMarker(carModel[car], plates[car], lat, lon, time);
        }
        Log.log("Runner", "сформовано точок маршрутів: " + total);
        Log.log("Runner", "кількість об'єктів позначок: " + markers.length);
        Log.log("Runner", "кількість об'єктів моделей: " + CarModelFactory.getCreatedCount() + " (очікується 4)");

        // Дві позначки РІЗНИХ авто ОДНІЄЇ моделі
        RouteMarker a = markers[0];
        RouteMarker b = null;
        for (RouteMarker m : markers) {
            if (m.getModel() == a.getModel() && !m.getPlate().equals(a.getPlate())) {
                b = m;
                break;
            }
        }
        Log.log("Runner", "позначка A: " + a.describe());
        Log.log("Runner", "позначка B: " + b.describe());
        Log.log("Runner", "A.model == B.model (той самий об'єкт)? " + (a.getModel() == b.getModel()));
    }

    static void task2Composite() {
        Zone city = new Zone("місто", "Київ");
        Zone d1 = new Zone("район", "Шевченківський");
        Zone d2 = new Zone("район", "Печерський");
        Zone q1 = new Zone("квартал", "Подільський");
        Zone q2 = new Zone("квартал", "Лук'янівський");
        Zone q3 = new Zone("квартал", "Липки");
        Zone bc = new Zone("бізнес-центр", "БЦ «Орієнтир»");

        bc.add(new ParkingLot("Майданчик БЦ-1", 12, 4800.50))
          .add(new ParkingLot("Майданчик БЦ-2", 8, 3150.00));
        q1.add(new ParkingLot("Майданчик П-1", 15, 5200.00))
          .add(new ParkingLot("Майданчик П-2", 10, 3900.75))
          .add(bc); // зона всередині кварталу
        q2.add(new ParkingLot("Майданчик Л-1", 20, 7600.00));
        q3.add(new ParkingLot("Майданчик Лп-1", 9, 4100.25));
        d1.add(q1).add(q2);
        d2.add(q3);
        city.add(d1).add(d2);

        city.print("");

        // Один і той самий виклик для різних вузлів
        for (ZoneComponent z : new ZoneComponent[]{city, d1}) {
            Log.log("Аналітика", String.format(java.util.Locale.US, "%s: авто=%d, виручка=%.2f грн",
                    z.getName(), z.getCarCount(), z.getRevenue()));
        }
    }

    static void task3Bridge() {
        ReportChannel app = new AppChannel();
        ReportChannel email = new EmailChannel();
        ReportChannel accounting = new AccountingChannel();

        Report trip = new TripReport(app, "Олена К.", 90123, 14, 32, 286.40);
        trip.send();                 // у застосунок
        trip.setChannel(email);      // той самий звіт — інший канал під час виконання
        trip.send();                 // на e-mail

        new CorporateReport(accounting, "ТОВ «Меридіан»", "жовтень 2026", 57, 18420.00).send();

        new UsageReport(email, "AA1003KC", 15230, 64).send(); // додатковий приклад комбінації

        // Новий канал — один клас, звіти не змінюються
        new TripReport(new TelegramBotChannel(), "Олена К.", 90177, 6, 15, 129.90).send();
    }
}
