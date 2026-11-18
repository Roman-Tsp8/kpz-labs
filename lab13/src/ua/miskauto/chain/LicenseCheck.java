package ua.miskauto.chain;

/** ConcreteHandler: підтвердження посвідчення водія. */
public class LicenseCheck extends CheckHandler {
    @Override protected String check(TripRequest r) {
        return r.getClient().isLicenseConfirmed() ? null : "посвідчення водія не підтверджено";
    }
    @Override public String name() { return "LicenseCheck"; }
}
