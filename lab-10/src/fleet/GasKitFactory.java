package fleet;

/** ConcreteFactory: авто на газу, додається без змін FleetService. */
public class GasKitFactory implements VehicleKitFactory {
    private static final String TYPE = "газ";

    public String carType() { return TYPE; }
    public TelematicsModule createTelematics() { return new Telematics(); }
    public EnergyCard createEnergyCard() { return new Card(); }
    public LevelSensor createLevelSensor() { return new Sensor(); }

    private static class Telematics implements TelematicsModule {
        public String carType() { return TYPE; }
        public String describe() { return "Телематика LPG-Track (тиск у балоні)"; }
    }
    private static class Card implements EnergyCard {
        public String carType() { return TYPE; }
        public String describe() { return "Картка газозаправної станції (LPG)"; }
    }
    private static class Sensor implements LevelSensor {
        public String carType() { return TYPE; }
        public String describe() { return "Датчик рівня газу в балоні"; }
    }
}
