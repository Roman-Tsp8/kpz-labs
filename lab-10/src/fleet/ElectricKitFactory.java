package fleet;

/** ConcreteFactory: електромобілі. */
public class ElectricKitFactory implements VehicleKitFactory {
    private static final String TYPE = "електро";

    public String carType() { return TYPE; }
    public TelematicsModule createTelematics() { return new Telematics(); }
    public EnergyCard createEnergyCard() { return new Card(); }
    public LevelSensor createLevelSensor() { return new Sensor(); }

    private static class Telematics implements TelematicsModule {
        public String carType() { return TYPE; }
        public String describe() { return "Телематика EV-Connect (стан батареї, запас ходу)"; }
    }
    private static class Card implements EnergyCard {
        public String carType() { return TYPE; }
        public String describe() { return "Картка зарядної мережі"; }
    }
    private static class Sensor implements LevelSensor {
        public String carType() { return TYPE; }
        public String describe() { return "Датчик рівня заряду батареї"; }
    }
}
