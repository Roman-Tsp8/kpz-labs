package lab11.adapter;

/** Власний формат телематики карти парку: десяткові координати, пальне у відсотках. */
public record TelematicsData(String carId, double latitude, double longitude, int fuelPercent) {
}
