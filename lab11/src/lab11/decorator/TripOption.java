package lab11.decorator;

import java.util.Locale;

import lab11.common.Log;

/** Decorator: базовий клас опції. Обгортає іншу поїздку, додає до опису й ставки свій внесок. */
public abstract class TripOption implements Trip {
    protected final Trip inner;

    protected TripOption(Trip inner) {
        this.inner = inner;
    }

    /** Назва опції для опису. */
    protected abstract String optionName();

    /** Надбавка до ставки за хвилину, грн. */
    protected abstract double surcharge();

    @Override
    public String description() {
        return inner.description() + " + " + optionName();
    }

    @Override
    public int minutes() {
        return inner.minutes();
    }

    @Override
    public double ratePerMinute() {
        double before = inner.ratePerMinute();
        double after = before + surcharge();
        Log.log(getClass().getSimpleName(), String.format(Locale.US,
                "додає %.2f грн/хв до ставки (%.2f → %.2f)", surcharge(), before, after));
        return after;
    }
}
