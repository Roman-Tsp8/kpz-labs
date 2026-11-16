package bridge;

/** RefinedAbstraction: щомісячний звіт для корпоративного клієнта. */
public class CorporateReport extends Report {
    private final String company;
    private final String month;
    private final int trips;
    private final double total;

    public CorporateReport(ReportChannel channel, String company, String month, int trips, double total) {
        super(channel);
        this.company = company;
        this.month = month;
        this.trips = trips;
        this.total = total;
    }

    @Override protected String getRecipient() { return company; }

    @Override protected String getTitle() { return "Щомісячний звіт за " + month; }

    @Override
    protected String buildBody() {
        return String.format(java.util.Locale.US, "поїздок %d, до сплати %.2f грн", trips, total);
    }
}
