package lab11.adapter;

/** Target: власний інтерфейс телематики, з яким працює карта парку. */
public interface TelematicsUnit {
    String carId();

    TelematicsData read();
}
