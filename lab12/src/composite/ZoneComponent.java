package composite;

/** Component: спільний інтерфейс для майданчика (листок) і зони (вузол). */
public interface ZoneComponent {
    String getName();

    int getCarCount();

    double getRevenue();

    /** Виводить піддерево в журнал з відступом. */
    void print(String indent);
}
