package rental;

import common.Log;
import java.time.Duration;

/** Creator: процес оренди описано один раз, вид поїздки визначає фабричний метод. */
public abstract class RentalProcess {
    private static final String SRC = "RentalProcess";

    /** Factory Method. */
    protected abstract Trip createTrip();

    public final double rent(String car, String client, Duration duration) {
        Log.log(SRC, "Перевірка авто " + car + " і клієнта " + client);
        Trip trip = createTrip();
        Log.log(SRC, "Відкрито поїздку (" + trip.kind() + ")");
        Log.log(SRC, "Поїздку завершено, тривалість: " + duration.toMinutes() + " хв");
        double cost = trip.cost(duration);
        Log.log(SRC, "Виставлено оплату: " + cost + " грн (" + trip.kind() + ")");
        return cost;
    }
}
