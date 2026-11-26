package mediator;

import common.EventLog;

/**
 * ConcreteMediator: диспетчерська. Тут зосереджені ВСІ правила реагування.
 * Служби між собою не спілкуються.
 */
public class DispatchCenter implements DispatchMediator {
    private static final String NAME = "DispatchCenter";

    private ClientApp clientApp;
    private FleetMap fleetMap;
    private TowService towService;
    private MaintenanceService maintenanceService;
    private SupportService supportService;
    private CarWashService carWashService; // необов'язкова: може бути не підключена

    public void registerClientApp(ClientApp service) {
        this.clientApp = service;
    }

    public void registerFleetMap(FleetMap service) {
        this.fleetMap = service;
    }

    public void registerTowService(TowService service) {
        this.towService = service;
    }

    public void registerMaintenanceService(MaintenanceService service) {
        this.maintenanceService = service;
    }

    public void registerSupportService(SupportService service) {
        this.supportService = service;
    }

    public void registerCarWashService(CarWashService service) {
        this.carWashService = service;
        EventLog.log(NAME, "підключено нову службу: " + service.getName());
    }

    @Override
    public void onServiceEvent(DispatchService sender, DispatchEvent event, String carId) {
        EventLog.log(NAME, "отримав " + event + " від " + sender.getName() + " (" + carId + ")");
        switch (event) {
            case ACCIDENT_REPORTED -> handleAccident(carId);
            case REPAIR_COMPLETED -> handleRepairCompleted(carId);
            case EVACUATION_COMPLETED -> handleEvacuationCompleted(carId);
            case WASH_COMPLETED -> handleWashCompleted(carId);
        }
    }

    // ---- правила взаємодії ----

    private void handleAccident(String carId) {
        order(clientApp, "завершити поїздку");
        clientApp.finishTrip(carId);

        order(towService, "викликати евакуатор");
        towService.dispatchTow(carId);

        order(fleetMap, "прибрати авто з карти");
        fleetMap.removeCar(carId);

        order(supportService, "прийняти звернення клієнта");
        supportService.openCase(carId, "ДТП");
    }

    private void handleRepairCompleted(String carId) {
        order(fleetMap, "повернути авто на карту");
        fleetMap.returnCar(carId);
    }

    private void handleEvacuationCompleted(String carId) {
        if (carWashService != null) {
            order(carWashService, "прийняти авто на мийку після евакуації");
            carWashService.washCar(carId);
        } else {
            order(maintenanceService, "прийняти авто після евакуації");
            maintenanceService.acceptCar(carId);
        }
    }

    private void handleWashCompleted(String carId) {
        order(maintenanceService, "прийняти авто після мийки");
        maintenanceService.acceptCar(carId);
    }

    private void order(DispatchService target, String task) {
        EventLog.log(NAME, "наказує " + target.getName() + ": " + task);
    }
}
