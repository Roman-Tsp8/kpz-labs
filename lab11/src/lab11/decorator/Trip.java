package lab11.decorator;

/** Component: поїздка. Базова і всі поїздки з опціями використовуються однаково. */
public interface Trip {
    String description();

    int minutes();

    double ratePerMinute();

    default double cost() {
        return minutes() * ratePerMinute();
    }
}
