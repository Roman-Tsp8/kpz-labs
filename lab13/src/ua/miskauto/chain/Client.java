package ua.miskauto.chain;

/** Клієнт каршерінгу. */
public class Client {
    private final String name;
    private final boolean licenseConfirmed;
    private final int drivingYears;
    private final int age;
    private final double debt;
    private final double cardBalance;
    private final boolean blocked;

    public Client(String name, boolean licenseConfirmed, int drivingYears, int age,
                  double debt, double cardBalance, boolean blocked) {
        this.name = name;
        this.licenseConfirmed = licenseConfirmed;
        this.drivingYears = drivingYears;
        this.age = age;
        this.debt = debt;
        this.cardBalance = cardBalance;
        this.blocked = blocked;
    }

    public String getName() { return name; }
    public boolean isLicenseConfirmed() { return licenseConfirmed; }
    public int getDrivingYears() { return drivingYears; }
    public int getAge() { return age; }
    public double getDebt() { return debt; }
    public double getCardBalance() { return cardBalance; }
    public boolean isBlocked() { return blocked; }
}
