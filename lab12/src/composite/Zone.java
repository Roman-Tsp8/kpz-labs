package composite;

import util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** Composite: зона довільного рівня (місто, район, квартал, бізнес-центр). Містить будь-які ZoneComponent. */
public class Zone implements ZoneComponent {
    private final String kind;
    private final String name;
    private final List<ZoneComponent> children = new ArrayList<>();

    public Zone(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    public Zone add(ZoneComponent child) {
        children.add(child);
        Log.log("Zone", "до «" + name + "» додано «" + child.getName() + "»");
        return this;
    }

    @Override public String getName() { return name; }

    @Override
    public int getCarCount() {
        int sum = 0;
        for (ZoneComponent c : children) sum += c.getCarCount(); // рекурсія: глибина не важлива
        return sum;
    }

    @Override
    public double getRevenue() {
        double sum = 0;
        for (ZoneComponent c : children) sum += c.getRevenue();
        return sum;
    }

    @Override
    public void print(String indent) {
        Log.log("Дерево", String.format(Locale.US, "%s[%s] %s: авто=%d, виручка=%.2f грн",
                indent, kind, name, getCarCount(), getRevenue()));
        for (ZoneComponent c : children) c.print(indent + "    ");
    }
}
