package observer;

import common.EventLog;

/** ConcreteObserver: диспетчер. Цікавиться ударами та виїздом із зони. */
public class Dispatcher implements CarEventListener {

    @Override
    public String getName() {
        return "Dispatcher";
    }

    @Override
    public void onCarEvent(CarEvent event) {
        switch (event.type()) {
            case CRASH -> EventLog.log(getName(),
                    event.carId() + ": відкриваю інцидент, зв'язуюсь із клієнтом, викликаю допомогу");
            case OUT_OF_ZONE -> EventLog.log(getName(),
                    event.carId() + ": перевіряю GPS-трек");
            default -> { /* заряд і завершення поїздки диспетчера не стосуються */ }
        }
    }
}
