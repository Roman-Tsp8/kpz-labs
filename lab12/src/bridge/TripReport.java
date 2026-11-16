package bridge;

/** RefinedAbstraction: звіт про поїздку для клієнта. */
public class TripReport extends Report {
    private final String client;
    private final int tripId;
    private final int km;
    private final int minutes;
    private final double cost;

    public TripReport(ReportChannel channel, String client, int tripId, int km, int minutes, double cost) {
        super(channel);
        this.client = client;
        this.tripId = tripId;
        this.km = km;
        this.minutes = minutes;
        this.cost = cost;
    }

    @Override protected String getRecipient() { return client; }

    @Override protected String getTitle() { return "Звіт про поїздку №" + tripId; }

    @Override
    protected String buildBody() {
        return String.format(java.util.Locale.US, "%d км, %d хв, вартість %.2f грн", km, minutes, cost);
    }
}
