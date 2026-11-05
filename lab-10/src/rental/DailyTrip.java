package rental;

import java.time.Duration;

/** ConcreteProduct: добова оренда. */
public class DailyTrip implements Trip {
    private static final double RATE = 1200.0; // грн/доба
    public String kind() { return "добова"; }
    public double cost(Duration d) { return Math.ceil(d.toMinutes() / 1440.0) * RATE; }
}
