package ua.miskauto.chain;

/** ConcreteHandler: відсутність блокування за порушення. */
public class BlockCheck extends CheckHandler {
    @Override protected String check(TripRequest r) {
        return r.getClient().isBlocked() ? "акаунт заблоковано за порушення" : null;
    }
    @Override public String name() { return "BlockCheck"; }
}
