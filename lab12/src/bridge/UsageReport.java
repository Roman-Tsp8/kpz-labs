package bridge;

/** RefinedAbstraction: звіт про використання авто для служби обслуговування. */
public class UsageReport extends Report {
    private final String plate;
    private final int mileage;
    private final int batteryPercent;

    public UsageReport(ReportChannel channel, String plate, int mileage, int batteryPercent) {
        super(channel);
        this.plate = plate;
        this.mileage = mileage;
        this.batteryPercent = batteryPercent;
    }

    @Override protected String getRecipient() { return "служба обслуговування"; }

    @Override protected String getTitle() { return "Використання авто " + plate; }

    @Override
    protected String buildBody() {
        return "пробіг " + mileage + " км, заряд " + batteryPercent + "%";
    }
}
