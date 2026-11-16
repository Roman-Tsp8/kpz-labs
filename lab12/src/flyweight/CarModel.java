package flyweight;

/** Flyweight: незмінні СПІЛЬНІ дані моделі авто (внутрішній стан). */
public final class CarModel {
    private final String name;
    private final String iconPath;
    private final int seats;
    private final int rangeKm;
    private final String photoPath;

    CarModel(String name, String iconPath, int seats, int rangeKm, String photoPath) {
        this.name = name;
        this.iconPath = iconPath;
        this.seats = seats;
        this.rangeKm = rangeKm;
        this.photoPath = photoPath;
    }

    public String getName() { return name; }

    public String describe() {
        return name + " (іконка=" + iconPath + ", місць=" + seats
                + ", запас ходу=" + rangeKm + " км, фото=" + photoPath + ")";
    }
}
