package bridge;

import util.Log;

/** ConcreteImplementor: e-mail. */
public class EmailChannel implements ReportChannel {
    @Override public String getName() { return "E-mail"; }

    @Override
    public void deliver(String recipient, String title, String body) {
        Log.log("EmailChannel", "лист на " + recipient + ", тема «" + title + "», текст: " + body);
    }
}
