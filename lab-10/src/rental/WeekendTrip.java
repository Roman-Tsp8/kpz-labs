package rental;

import java.time.Duration;

/** ConcreteProduct: вихідні оренда. */
public class WeekendTrip implements Trip {
    private static final double RATE = 1500.0; // фіксовано
    public String kind() { return "вихідні"; }
    public double cost(Duration d) { return RATE; }
}
