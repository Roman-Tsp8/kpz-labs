package ua.miskauto.chain;

/** ConcreteHandler: мінімальний вік для спорткарів (додається без змін в існуючих класах). */
public class AgeCheck extends CheckHandler {
    private final int minAge;

    public AgeCheck(int minAge) { this.minAge = minAge; }

    @Override protected String check(TripRequest r) {
        if (r.getVehicle().isSports() && r.getClient().getAge() < minAge) {
            return "вік " + r.getClient().getAge() + " менший за мінімальний для спорткарів (" + minAge + ")";
        }
        return null;
    }
    @Override public String name() { return "AgeCheck"; }
}
