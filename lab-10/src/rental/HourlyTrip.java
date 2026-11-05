package rental;

import java.time.Duration;

/** ConcreteProduct: погодинна оренда. */
public class HourlyTrip implements Trip {
    private static final double RATE = 250.0; // грн/год
    public String kind() { return "погодинна"; }
    public double cost(Duration d) { return Math.ceil(d.toMinutes() / 60.0) * RATE; }
}
