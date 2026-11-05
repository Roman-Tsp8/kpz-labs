package booking;

import common.Log;
import java.time.Clock;
import java.time.LocalDateTime;

/** Builder: покрокове формування; валідація — на завершальному кроці build(). */
public class BookingBuilder {
    private static final String SRC = "BookingBuilder";

    private final Clock clock;
    private String client;
    private String car;
    private LocalDateTime startTime;
    private boolean childSeat;
    private boolean extraInsurance;
    private String deliveryAddress;
    private String comment;

    public BookingBuilder(Clock clock) { this.clock = clock; }

    public BookingBuilder client(String client) {
        this.client = client; Log.log(SRC, "Клієнт: " + client); return this;
    }
    public BookingBuilder car(String car) {
        this.car = car; Log.log(SRC, "Авто: " + car); return this;
    }
    public BookingBuilder startTime(LocalDateTime t) {
        this.startTime = t; Log.log(SRC, "Час початку: " + t); return this;
    }
    public BookingBuilder withChildSeat() {
        this.childSeat = true; Log.log(SRC, "Опція: дитяче крісло"); return this;
    }
    public BookingBuilder withExtraInsurance() {
        this.extraInsurance = true; Log.log(SRC, "Опція: додаткове страхування"); return this;
    }
    public BookingBuilder deliveredTo(String address) {
        this.deliveryAddress = address; Log.log(SRC, "Опція: подача до адреси " + address); return this;
    }
    public BookingBuilder comment(String comment) {
        this.comment = comment; Log.log(SRC, "Коментар: " + comment); return this;
    }

    public Booking build() {
        if (client == null || client.isBlank()) fail("не вказано клієнта");
        if (car == null || car.isBlank()) fail("не обрано автомобіль");
        if (startTime == null) fail("не вказано час початку");
        if (startTime.isBefore(LocalDateTime.now(clock))) fail("час початку в минулому");
        Booking b = new Booking(client, car, startTime, childSeat, extraInsurance, deliveryAddress, comment);
        Log.log(SRC, "Бронювання сформовано");
        return b;
    }

    private void fail(String reason) {
        String msg = "Неможливо сформувати бронювання: " + reason;
        Log.log(SRC, msg);
        throw new BookingException(msg);
    }
}
