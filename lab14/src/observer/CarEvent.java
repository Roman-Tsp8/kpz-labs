package observer;

/** Незмінне повідомлення, яке авто розсилає підписникам. */
public record CarEvent(CarEventType type, String carId, String details) {
}
