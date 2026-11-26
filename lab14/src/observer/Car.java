package observer;

import common.EventLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: авто з телематикою.
 * Не знає жодного конкретного отримувача — працює лише з інтерфейсом CarEventListener.
 */
public class Car {
    private final String id;
    private final List<CarEventListener> listeners = new ArrayList<>();

    public Car(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void subscribe(CarEventListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
        EventLog.log(source(), "підписано: " + listener.getName());
    }

    public void unsubscribe(CarEventListener listener) {
        if (listeners.remove(listener)) {
            EventLog.log(source(), "відписано: " + listener.getName());
        }
    }

    // ---- події, які фіксує телематика ----

    public void reportLowBattery(int percent) {
        publish(new CarEvent(CarEventType.LOW_BATTERY, id, "заряд " + percent + "%"));
    }

    public void reportCrash() {
        publish(new CarEvent(CarEventType.CRASH, id, "зафіксовано удар"));
    }

    public void reportOutOfZone() {
        publish(new CarEvent(CarEventType.OUT_OF_ZONE, id, "авто залишило зону обслуговування"));
    }

    public void finishTrip() {
        publish(new CarEvent(CarEventType.TRIP_FINISHED, id, "поїздку завершено"));
    }

    private void publish(CarEvent event) {
        EventLog.log(source(), "подія " + event.type() + " (" + event.details()
                + "), сповіщаю підписників: " + listeners.size());
        // Копія списку: отримувач може відписатися прямо під час сповіщення.
        for (CarEventListener listener : new ArrayList<>(listeners)) {
            listener.onCarEvent(event);
        }
    }

    private String source() {
        return "Car " + id;
    }
}
