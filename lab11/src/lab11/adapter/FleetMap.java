package lab11.adapter;

import java.util.ArrayList;
import java.util.List;

import lab11.common.Log;

/** Client: карта парку. Працює лише з TelematicsUnit і нічого не знає про виробників. */
public class FleetMap {
    private final List<TelematicsUnit> units = new ArrayList<>();

    public void addUnit(TelematicsUnit unit) {
        units.add(unit);
    }

    public void render() {
        Log.log("FleetMap", "оновлення карти парку, авто: " + units.size());
        for (TelematicsUnit unit : units) {
            TelematicsData d = unit.read();
            Log.log("FleetMap", String.format("відображено авто %s: (%.5f; %.5f), пальне %d%%",
                    d.carId(), d.latitude(), d.longitude(), d.fuelPercent()));
        }
    }
}
