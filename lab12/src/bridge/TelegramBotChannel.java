package bridge;

import util.Log;

/** Новий канал: додається ОДНИМ класом, без змін у звітах. */
public class TelegramBotChannel implements ReportChannel {
    @Override public String getName() { return "Telegram-бот"; }

    @Override
    public void deliver(String recipient, String title, String body) {
        Log.log("TelegramBotChannel", "повідомлення боту для " + recipient + ": «" + title + "» — " + body);
    }
}
