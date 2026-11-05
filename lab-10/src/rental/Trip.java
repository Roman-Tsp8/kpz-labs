package rental;

import java.time.Duration;

/** Product. */
public interface Trip {
    String kind();    //назви виду там по хвиланах годинах і тд
    double cost(Duration duration);  //скільки коштує
}
