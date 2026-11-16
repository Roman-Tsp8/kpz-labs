package bridge;

import util.Log;

/** Abstraction: ВИД звіту (що містить). Тримає міст-посилання на канал. */
public abstract class Report {
    protected ReportChannel channel; // міст

    protected Report(ReportChannel channel) {
        this.channel = channel;
    }

    public void setChannel(ReportChannel channel) {
        this.channel = channel;
    }

    protected abstract String getRecipient();

    protected abstract String getTitle();

    protected abstract String buildBody();

    public void send() {
        Log.log(getClass().getSimpleName(), "відправка через канал «" + channel.getName() + "»");
        channel.deliver(getRecipient(), getTitle(), buildBody());
    }
}
