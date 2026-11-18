package ua.miskauto.chain;

/** Результат проходження ланцюга перевірок. */
public class CheckResult {
    private final boolean approved;
    private final String reason;
    private final String decidedBy;

    private CheckResult(boolean approved, String reason, String decidedBy) {
        this.approved = approved;
        this.reason = reason;
        this.decidedBy = decidedBy;
    }

    public static CheckResult approved(String decidedBy) { return new CheckResult(true, "усі перевірки пройдено", decidedBy); }
    public static CheckResult rejected(String reason, String decidedBy) { return new CheckResult(false, reason, decidedBy); }

    public boolean isApproved() { return approved; }
    public String getReason() { return reason; }
    public String getDecidedBy() { return decidedBy; }
}
