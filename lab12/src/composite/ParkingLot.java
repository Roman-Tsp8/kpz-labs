package composite;

import util.Log;
import java.util.Locale;

/** Leaf: окремий паркувальний майданчик. */
public class ParkingLot implements ZoneComponent {
    private final String name;
    private final int carCount;
    private final double revenue;

    public ParkingLot(String name, int carCount, double revenue) {
        this.name = name;
        this.carCount = carCount;
        this.revenue = revenue;
    }

    @Override public String getName() { return name; }

    @Override public int getCarCount() { return carCount; }

    @Override public double getRevenue() { return revenue; }

    @Override
    public void print(String indent) {
        Log.log("Дерево", String.format(Locale.US, "%s[майданчик] %s: авто=%d, виручка=%.2f грн",
                indent, name, carCount, revenue));
    }
}
