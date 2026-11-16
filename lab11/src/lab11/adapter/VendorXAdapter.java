package lab11.adapter;

import lab11.common.Log;

/** Adapter: приводить блок виробника X до власного інтерфейсу TelematicsUnit. Уся конвертація — тут. */
public class VendorXAdapter implements TelematicsUnit {
    private final String carId;
    private final VendorXTelematicsBlock block;

    public VendorXAdapter(String carId, VendorXTelematicsBlock block) {
        this.carId = carId;
        this.block = block;
    }

    @Override
    public String carId() {
        return carId;
    }

    @Override
    public TelematicsData read() {
        Log.log("VendorXAdapter", "запитую дані у блоку " + block.getSerial() + " (формат виробника)");
        Dms lat = block.fetchLatitudeDms();
        Dms lon = block.fetchLongitudeDms();
        double liters = block.fetchFuelLiters();
        double tank = block.fetchTankCapacityLiters();

        double latDec = toDecimal(lat);
        double lonDec = toDecimal(lon);
        int percent = (int) Math.round(liters / tank * 100.0);

        Log.log("VendorXAdapter", String.format(
                "перетворено у власний формат: lat=%.5f lon=%.5f, пальне %d%%", latDec, lonDec, percent));
        return new TelematicsData(carId, latDec, lonDec, percent);
    }

    private static double toDecimal(Dms d) {
        double value = d.degrees() + d.minutes() / 60.0 + d.seconds() / 3600.0;
        return (d.hemisphere() == 'S' || d.hemisphere() == 'W') ? -value : value;
    }
}
