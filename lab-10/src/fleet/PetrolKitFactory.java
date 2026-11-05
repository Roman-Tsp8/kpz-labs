package fleet;

/** ConcreteFactory: бензинові авто. */
public class PetrolKitFactory implements VehicleKitFactory {
    private static final String TYPE = "бензин";

    public String carType() { return TYPE; }
    public TelematicsModule createTelematics() { return new Telematics(); }
    public EnergyCard createEnergyCard() { return new Card(); }
    public LevelSensor createLevelSensor() { return new Sensor(); }

    private static class Telematics implements TelematicsModule {
        public String carType() { return TYPE; }
        public String describe() { return "Телематика ICE-GPS (облік пального, пробіг)"; }
    }
    private static class Card implements EnergyCard {
        public String carType() { return TYPE; }
        public String describe() { return "Паливна картка АЗС (А-95)"; }
    }
    private static class Sensor implements LevelSensor {
        public String carType() { return TYPE; }
        public String describe() { return "Датчик рівня пального в баку"; }
    }
}
