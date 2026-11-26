package com.miskavto.lab15.strategy;

import com.miskavto.lab15.common.Log;

import java.util.Locale;

public class Trip {
    private static final double PEAK_COEFFICIENT = 1.3;

    private final String customer;
    private final int minutes;
    private final double km;
    private final boolean peakHour;
    private TariffStrategy tariff;

    public Trip(String customer, int minutes, double km, boolean peakHour, TariffStrategy tariff) {
        this.customer = customer;
        this.minutes = minutes;
        this.km = km;
        this.peakHour = peakHour;
        this.tariff = tariff;
    }

    public void setTariff(TariffStrategy newTariff) {
        Log.log(source(), "Тариф змінено: «" + tariff.getName() + "» → «" + newTariff.getName() + "»");
        this.tariff = newTariff;
    }

    public double calculateCost() {
        double base = tariff.calculate(minutes, km);
        double total = peakHour ? base * PEAK_COEFFICIENT : base;
        String peak = peakHour
                ? String.format(Locale.US, " (година пік ×%.1f, база %.2f грн)", PEAK_COEFFICIENT, base)
                : "";
        Log.log(source(), String.format(Locale.US,
                "Тариф «%s»: %d хв, %.1f км → %.2f грн%s",
                tariff.getName(), minutes, km, total, peak));
        return total;
    }

    private String source() { return "Trip:" + customer; }
}
