package lab11.adapter;

import lab11.common.Log;

/** Adaptee: телематичний блок стороннього виробника. Код змінювати не можна. */
public class VendorXTelematicsBlock {
    private final String serial;
    private final Dms lat;
    private final Dms lon;
    private final double fuelLiters;
    private final double tankLiters;

    public VendorXTelematicsBlock(String serial, Dms lat, Dms lon, double fuelLiters, double tankLiters) {
        this.serial = serial;
        this.lat = lat;
        this.lon = lon;
        this.fuelLiters = fuelLiters;
        this.tankLiters = tankLiters;
    }

    public String getSerial() {
        return serial;
    }

    public Dms fetchLatitudeDms() {
        Log.log("VendorXBlock", "повертає широту у форматі ГМС: " + lat);
        return lat;
    }

    public Dms fetchLongitudeDms() {
        Log.log("VendorXBlock", "повертає довготу у форматі ГМС: " + lon);
        return lon;
    }

    public double fetchFuelLiters() {
        Log.log("VendorXBlock", "повертає пальне: " + fuelLiters + " л");
        return fuelLiters;
    }

    public double fetchTankCapacityLiters() {
        Log.log("VendorXBlock", "повертає об'єм бака: " + tankLiters + " л");
        return tankLiters;
    }
}
