package booking;

import java.time.LocalDateTime;

/** Product: незмінний, конструктор пакетний — створити можна лише через білдер. */
public final class Booking {
    private final String client;
    private final String car;
    private final LocalDateTime startTime;
    private final boolean childSeat;
    private final boolean extraInsurance;
    private final String deliveryAddress; // може бути null
    private final String comment;         // може бути null

    Booking(String client, String car, LocalDateTime startTime, boolean childSeat,
            boolean extraInsurance, String deliveryAddress, String comment) {
        this.client = client;
        this.car = car;
        this.startTime = startTime;
        this.childSeat = childSeat;
        this.extraInsurance = extraInsurance;
        this.deliveryAddress = deliveryAddress;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Бронювання {\n"
                + "  клієнт: " + client + "\n"
                + "  авто: " + car + "\n"
                + "  початок: " + startTime + "\n"
                + "  дитяче крісло: " + (childSeat ? "так" : "ні") + "\n"
                + "  додаткове страхування: " + (extraInsurance ? "так" : "ні") + "\n"
                + "  подача до адреси: " + (deliveryAddress == null ? "—" : deliveryAddress) + "\n"
                + "  коментар: " + (comment == null ? "—" : comment) + "\n}";
    }
}
