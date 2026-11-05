package booking;

import java.time.LocalDateTime;

/** Director: типові бронювання — послідовність кроків описана в одному місці. */
public class BookingDirector {
    public Booking airport(BookingBuilder b, String client, String car, LocalDateTime start) {
        return b.client(client).car(car).startTime(start)
                .deliveredTo("Аеропорт")
                .withExtraInsurance()
                .comment("Поїздка в аеропорт")
                .build();
    }

    public Booking tripWithChild(BookingBuilder b, String client, String car, LocalDateTime start) {
        return b.client(client).car(car).startTime(start)
                .withChildSeat()
                .withExtraInsurance()
                .build();
    }
}
