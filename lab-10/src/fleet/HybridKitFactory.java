package fleet;

/** ConcreteFactory: гібриди. */
public class HybridKitFactory implements VehicleKitFactory {
    private static final String TYPE = "гібрид";

    public String carType() { return TYPE; }
    public TelematicsModule createTelematics() { return new Telematics(); }
    public EnergyCard createEnergyCard() { return new Card(); }
    public LevelSensor createLevelSensor() { return new Sensor(); }

    private static class Telematics implements TelematicsModule {
        public String carType() { return TYPE; }
        public String describe() { return "Телематика HEV-Link (двигун + батарея)"; }
    }
    private static class Card implements EnergyCard {
        public String carType() { return TYPE; }
        public String describe() { return "Комбінована картка (АЗС + зарядна станція)"; }
    }
    private static class Sensor implements LevelSensor {
        public String carType() { return TYPE; }
        public String describe() { return "Подвійний датчик: пальне + заряд батареї"; }
    }
}
