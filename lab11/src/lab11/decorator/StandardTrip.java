package lab11.decorator;

import java.util.Locale;

import lab11.common.Log;

/** ConcreteComponent: звичайна поїздка. */
public class StandardTrip implements Trip {
    private final int minutes;
    private final double baseRate;

    public StandardTrip(int minutes, double baseRate) {
        this.minutes = minutes;
        this.baseRate = baseRate;
    }

    @Override
    public String description() {
        return "Поїздка " + minutes + " хв";
    }

    @Override
    public int minutes() {
        return minutes;
    }

    @Override
    public double ratePerMinute() {
        Log.log("StandardTrip", String.format(Locale.US, "базова ставка %.2f грн/хв", baseRate));
        return baseRate;
    }
}
