package ua.miskauto;

import ua.miskauto.chain.*;
import ua.miskauto.command.*;
import ua.miskauto.log.EventLog;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/** Раннер: окремий метод для кожної проблемної ситуації варіанта 8 «Каршерінг «Міськавто»». */
public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8)); // коректна кирилиця в консолі
        runRemoteCommands();   // Завдання 1 — Command
        runTripAdmission();    // Завдання 2 — Chain of Responsibility
    }

    /** Завдання 1. Віддалені команди авто (Command). */
    static void runRemoteCommands() {
        EventLog.section("Завдання 1. Віддалені команди авто (Command)");
        Car car = new Car("AA1234KA");
        CommandCenter center = new CommandCenter();

        EventLog.log("Runner", "сценарій 1: «відкрити» і «заблокувати двигун»");
        center.send(new OpenDoorsCommand(car, "служба підтримки"));
        center.send(new BlockEngineCommand(car, "служба підтримки"));
        EventLog.log("Runner", "стан авто: " + car);

        EventLog.log("Runner", "сценарій 2: скасувати блокування двигуна");
        center.undoLast();
        EventLog.log("Runner", "стан авто: " + car);

        EventLog.log("Runner", "сценарій 3: авто втратило зв'язок, надсилаємо 2 команди");
        car.setOnline(false);
        center.send(new AlarmCommand(car, "клієнт"));
        center.send(new CloseDoorsCommand(car, "клієнт"));
        EventLog.log("Runner", "у черзі команд: " + center.pendingCount() + "; стан авто: " + car);
        car.setOnline(true);
        center.onCarReconnected(car);
        EventLog.log("Runner", "стан авто: " + car);

        center.printAuditLog();
    }

    /** Завдання 2. Допуск клієнта до поїздки (Chain of Responsibility). */
    static void runTripAdmission() {
        EventLog.section("Завдання 2. Допуск клієнта до поїздки (Chain of Responsibility)");
        Vehicle economy = new Vehicle("Renault Zoe", false, false, 500);
        Vehicle premium = new Vehicle("BMW 5", true, false, 2000);
        Vehicle sports = new Vehicle("Porsche 911", true, true, 3000);

        EventLog.log("Runner", "сценарій 1: клієнт проходить усі перевірки (звичайне авто)");
        CheckHandler standard = CheckChainFactory.standard();
        Client ok = new Client("Іван Петренко", true, 8, 35, 0, 1500, false);
        report(standard.handle(new TripRequest(ok, economy)));

        EventLog.log("Runner", "сценарій 2: клієнт із заборгованістю (звичайне авто)");
        Client debtor = new Client("Олег Шевчук", true, 6, 40, 250, 1500, false);
        report(CheckChainFactory.standard().handle(new TripRequest(debtor, economy)));

        EventLog.log("Runner", "сценарій 3: клієнт зі стажем 1 рік бере преміальне авто");
        Client novice = new Client("Марія Коваль", true, 1, 27, 0, 5000, false);
        report(CheckChainFactory.premium().handle(new TripRequest(novice, premium)));

        EventLog.log("Runner", "сценарій 4 (додатково): нова перевірка віку для спорткарів вбудовується без змін в існуючих ланках");
        CheckHandler withAge = CheckChainFactory.build(List.of(new LicenseCheck(), new ExperienceCheck(3),
                new AgeCheck(25), new DebtCheck(), new BalanceCheck(), new BlockCheck()));
        Client young = new Client("Андрій Мельник", true, 4, 22, 0, 5000, false);
        report(withAge.handle(new TripRequest(young, sports)));
    }

    private static void report(CheckResult r) {
        EventLog.log("Runner", (r.isApproved() ? "РЕЗУЛЬТАТ: допуск надано" : "РЕЗУЛЬТАТ: відмова")
                + " — " + r.getReason() + " (ухвалила ланка: " + r.getDecidedBy() + ")");
    }
}
