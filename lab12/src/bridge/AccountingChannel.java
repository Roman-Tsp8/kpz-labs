package bridge;

import util.Log;

/** ConcreteImplementor: система бухгалтерії клієнта. */
public class AccountingChannel implements ReportChannel {
    @Override public String getName() { return "Бухгалтерія"; }

    @Override
    public void deliver(String recipient, String title, String body) {
        Log.log("AccountingChannel", "запис у бухгалтерію " + recipient + ": «" + title + "» — " + body);
    }
}
