package flyweight;

/** унікальні дані позначки (зовнішній стан) + посилання на спільну модель. */
public final class RouteMarker {
    private final CarModel model;   // посилання на flyweight
    private final String plate;
    private final double lat;
    private final double lon;
    private final String time;

    public RouteMarker(CarModel model, String plate, double lat, double lon, String time) {
        this.model = model;
        this.plate = plate;
        this.lat = lat;
        this.lon = lon;
        this.time = time;
    }

    public CarModel getModel() { return model; }

    public String getPlate() { return plate; }

    public String describe() {
        return String.format("авто %s, координати (%.4f; %.4f), час %s, модель: %s",
                plate, lat, lon, time, model.describe());
    }
}
