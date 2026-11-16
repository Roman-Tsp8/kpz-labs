package bridge;

/** Implementor: КАНАЛ доставки (як доставляється). */
public interface ReportChannel {
    String getName();

    void deliver(String recipient, String title, String body);
}
