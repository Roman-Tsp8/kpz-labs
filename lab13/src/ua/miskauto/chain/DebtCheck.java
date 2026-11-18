package ua.miskauto.chain;

/** ConcreteHandler: відсутність заборгованості. */
public class DebtCheck extends CheckHandler {
    @Override protected String check(TripRequest r) {
        double debt = r.getClient().getDebt();
        return debt > 0 ? "є заборгованість " + debt + " грн" : null;
    }
    @Override public String name() { return "DebtCheck"; }
}
