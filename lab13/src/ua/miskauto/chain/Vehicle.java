package ua.miskauto.chain;

/** Авто, яке клієнт хоче взяти. */
public class Vehicle {
    private final String model;
    private final boolean premium;
    private final boolean sports;
    private final double minDeposit;

    public Vehicle(String model, boolean premium, boolean sports, double minDeposit) {
        this.model = model;
        this.premium = premium;
        this.sports = sports;
        this.minDeposit = minDeposit;
    }

    public String getModel() { return model; }
    public boolean isPremium() { return premium; }
    public boolean isSports() { return sports; }
    public double getMinDeposit() { return minDeposit; }
}
