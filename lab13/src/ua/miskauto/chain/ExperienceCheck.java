package ua.miskauto.chain;

/** ConcreteHandler: стаж водіння для преміальних авто. */
public class ExperienceCheck extends CheckHandler {
    private final int requiredYears;

    public ExperienceCheck(int requiredYears) { this.requiredYears = requiredYears; }

    @Override protected String check(TripRequest r) {
        if (r.getVehicle().isPremium() && r.getClient().getDrivingYears() < requiredYears) {
            return "стаж " + r.getClient().getDrivingYears() + " р. менший за потрібний для преміальних авто ("
                    + requiredYears + " р.)";
        }
        return null;
    }
    @Override public String name() { return "ExperienceCheck"; }
}
