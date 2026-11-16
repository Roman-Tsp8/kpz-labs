package lab11;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import lab11.adapter.Dms;
import lab11.adapter.FleetMap;
import lab11.adapter.NativeTelematicsUnit;
import lab11.adapter.TelematicsData;
import lab11.adapter.VendorXAdapter;
import lab11.adapter.VendorXTelematicsBlock;
import lab11.common.Log;
import lab11.decorator.ChildSeat;
import lab11.decorator.FullInsurance;
import lab11.decorator.OutOfCity;
import lab11.decorator.RoofRack;
import lab11.decorator.SecondDriver;
import lab11.decorator.StandardTrip;
import lab11.decorator.Trip;
import lab11.facade.CarReservationService;
import lab11.facade.Dispatcher;
import lab11.facade.DoorLockService;
import lab11.facade.DriverLicenseService;
import lab11.facade.InsuranceService;
import lab11.facade.MobileApp;
import lab11.facade.PaymentService;
import lab11.facade.SupportCenter;
import lab11.facade.TelematicsService;
import lab11.facade.TripFacade;
import lab11.proxy.CarAccessProxy;
import lab11.proxy.CarCommands;
import lab11.proxy.RemoteCarController;
import lab11.proxy.RentalRegistry;

/** Раннер: окремий метод для кожної проблемної ситуації варіанта 8 «Міськавто». */
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        task1Adapter();
        task2Facade();
        task3Proxy();
        task4Decorator();
    }

    /** Завдання 1. Підключення телематики нового постачальника — Adapter. */
    static void task1Adapter() {
        Log.section("Завдання 1. Adapter: телематика нового постачальника");

        VendorXTelematicsBlock rawBlock = new VendorXTelematicsBlock("VX-77001",
                new Dms(48, 17, 30.0, 'N'), new Dms(25, 56, 6.0, 'E'), 21.0, 60.0);
        VendorXAdapter newCar = new VendorXAdapter("CE1234AA", rawBlock);
        NativeTelematicsUnit oldCar = new NativeTelematicsUnit(
                new TelematicsData("CE5678BB", 48.29150, 25.94030, 80));

        Log.log("Runner", "--- дані з нового блоку через адаптер (у журналі і вихідні, і перетворені значення)");
        FleetMap map = new FleetMap();
        map.addUnit(newCar);
        map.render();

        Log.log("Runner", "--- на карті одночасно авто зі старим і новим блоками");
        map.addUnit(oldCar);
        map.render();
    }

    /** Завдання 2. Початок поїздки — Facade. */
    static void task2Facade() {
        Log.section("Завдання 2. Facade: початок поїздки");

        DoorLockService doorLock = new DoorLockService();
        TripFacade facade = new TripFacade(new DriverLicenseService(), new PaymentService(),
                new CarReservationService(), doorLock, new TelematicsService(), new InsuranceService());
        MobileApp app = new MobileApp(facade);
        Dispatcher dispatcher = new Dispatcher(facade);
        SupportCenter support = new SupportCenter(doorLock);

        Log.log("Runner", "--- початок поїздки через застосунок");
        app.pressStart("Ткачук", "CE1234AA");

        Log.log("Runner", "--- початок поїздки через диспетчера (та сама операція)");
        dispatcher.startTripForClient("Мельник", "CE5678BB");

        Log.log("Runner", "--- окреме розблокування дверей службою підтримки");
        support.remoteUnlock("CE1234AA");
    }

    /** Завдання 3. Керування авто через віддалений сервер — Proxy. */
    static void task3Proxy() {
        Log.section("Завдання 3. Proxy: керування авто через віддалений сервер");

        RentalRegistry registry = new RentalRegistry();
        registry.rent("CE1234AA", "Ткачук");

        RemoteCarController real = new RemoteCarController("CE1234AA");
        CarAccessProxy proxy = new CarAccessProxy("CE1234AA", real, registry);
        CarCommands car = proxy; // застосунок бачить лише інтерфейс

        Log.log("Runner", "--- орендар Ткачук відкриває двері CE1234AA");
        car.openDoors("Ткачук");

        Log.log("Runner", "--- інший клієнт Мельник намагається відкрити CE1234AA");
        car.openDoors("Мельник");

        Log.log("Runner", "--- журнал команд (веде проксі)");
        proxy.getAuditLog().forEach(entry -> Log.log("Runner", entry));
        Log.log("Runner", "звернень до сервера виробника: " + real.getServerCalls());
    }

    /** Завдання 4. Додаткові опції поїздки — Decorator. */
    static void task4Decorator() {
        Log.section("Завдання 4. Decorator: опції поїздки");

        Log.log("Runner", "--- звичайна 30-хвилинна поїздка");
        Trip plain = new StandardTrip(30, 4.00);
        report(plain);

        Log.log("Runner", "--- + повне страхування, дитяче крісло, другий водій");
        Trip withOptions = new SecondDriver(new ChildSeat(new FullInsurance(new StandardTrip(30, 4.00))));
        report(withOptions);

        Log.log("Runner", "--- інша поїздка (45 хв): за межі міста + багажник на дах");
        Trip outOfCity = new RoofRack(new OutOfCity(new StandardTrip(45, 4.00)));
        report(outOfCity);
    }

    private static void report(Trip trip) {
        double cost = trip.cost();
        Log.log("Runner", "опис: " + trip.description());
        Log.log("Runner", String.format("підсумкова ставка %.2f грн/хв, вартість %.2f грн",
                cost / trip.minutes(), cost));
    }
}
