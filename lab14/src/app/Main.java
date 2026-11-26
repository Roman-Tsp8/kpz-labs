package app;

import common.EventLog;
import mediator.CarWashService;
import mediator.ClientApp;
import mediator.DispatchCenter;
import mediator.FleetMap;
import mediator.MaintenanceService;
import mediator.SupportService;
import mediator.TowService;
import observer.Car;
import observer.Client;
import observer.Dispatcher;
import observer.FleetService;
import observer.InsuranceCompany;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/** Раннер: окремий метод для кожної проблемної ситуації варіанта 8. */
public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        situation1CarEvents();
        EventLog.reset();
        situation2Dispatch();
    }

    /** Завдання 1: події авто (Observer). */
    static void situation1CarEvents() {
        EventLog.header("Завдання 1. Події авто (Observer)");

        Car car = new Car("CAR-17");
        FleetService fleet = new FleetService();
        Dispatcher dispatcher = new Dispatcher();
        InsuranceCompany insurance = new InsuranceCompany();
        Client client = new Client("Іван");

        // Постійні підписники
        car.subscribe(fleet);
        car.subscribe(dispatcher);
        car.subscribe(insurance);

        System.out.println("--- Сценарій 1: початок поїздки, заряд падає до 10% ---");
        client.startTrip(car);
        car.reportLowBattery(10);

        System.out.println("--- Сценарій 2: удар ---");
        car.reportCrash();

        System.out.println("--- Сценарій 3: кінець поїздки, клієнт відписується ---");
        car.finishTrip();
        client.endTrip(car);
        car.reportLowBattery(5); // клієнт цього вже не отримає
    }

    /** Завдання 2: диспетчерська служба (Mediator). */
    static void situation2Dispatch() {
        EventLog.header("Завдання 2. Диспетчерська служба (Mediator)");

        DispatchCenter center = new DispatchCenter();
        ClientApp clientApp = new ClientApp(center);
        FleetMap fleetMap = new FleetMap(center, List.of("CAR-17"));
        TowService towService = new TowService(center);
        MaintenanceService maintenance = new MaintenanceService(center);
        SupportService support = new SupportService(center);

        center.registerClientApp(clientApp);
        center.registerFleetMap(fleetMap);
        center.registerTowService(towService);
        center.registerMaintenanceService(maintenance);
        center.registerSupportService(support);

        System.out.println("--- Сценарій 1: завершення ремонту ---");
        maintenance.completeRepair("CAR-08");

        System.out.println("--- Сценарій 2: клієнт повідомляє про ДТП ---");
        clientApp.reportAccident("CAR-17");

        System.out.println("--- Сценарій 3: підключення мийки, евакуація завершена ---");
        CarWashService wash = new CarWashService(center);
        center.registerCarWashService(wash);
        towService.completeEvacuation("CAR-17");
    }
}
