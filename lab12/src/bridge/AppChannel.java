package bridge;

import util.Log;

/** ConcreteImplementor: застосунок. */
public class AppChannel implements ReportChannel {
    @Override public String getName() { return "Застосунок"; }

    @Override
    public void deliver(String recipient, String title, String body) {
        Log.log("AppChannel", "push-сповіщення для " + recipient + ": «" + title + "» — " + body);
    }
}
