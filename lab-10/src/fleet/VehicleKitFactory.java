package fleet;

/**(інтерфейс фабрики) видає узгоджений набір елементів одного типу авто. */
public interface VehicleKitFactory {
    String carType();
    TelematicsModule createTelematics();
    EnergyCard createEnergyCard();
    LevelSensor createLevelSensor();
}
