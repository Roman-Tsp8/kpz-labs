package rental;

import java.time.Duration;

/** ConcreteProduct: хвилинна оренда. */
public class MinuteTrip implements Trip {
    private static final double RATE = 5.0; // грн/хв
    public String kind() { return "хвилинна"; }
    public double cost(Duration d) { return d.toMinutes() * RATE; }
}
