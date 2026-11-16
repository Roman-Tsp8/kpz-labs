package lab11.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Реєстр оренд: хто зараз орендує яке авто. */
public class RentalRegistry {
    private final Map<String, String> renters = new HashMap<>();

    public void rent(String carId, String clientId) {
        renters.put(carId, clientId);
    }

    public Optional<String> renterOf(String carId) {
        return Optional.ofNullable(renters.get(carId));
    }
}
