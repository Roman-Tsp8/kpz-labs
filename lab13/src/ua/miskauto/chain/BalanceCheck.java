package ua.miskauto.chain;

/** ConcreteHandler: наявність коштів на картці. */
public class BalanceCheck extends CheckHandler {
    @Override protected String check(TripRequest r) {
        double need = r.getVehicle().getMinDeposit();
        double have = r.getClient().getCardBalance();
        return have < need ? "недостатньо коштів на картці: " + have + " грн, потрібно " + need + " грн" : null;
    }
    @Override public String name() { return "BalanceCheck"; }
}
