package flyweight;

import util.Log;
import java.util.HashMap;
import java.util.Map;

/** FlyweightFactory: повертає наявний об'єкт моделі або створює новий лише при першому запиті. */
public final class CarModelFactory {
    private static final Map<String, CarModel> CACHE = new HashMap<>();

    private CarModelFactory() {
    }

    public static CarModel getModel(String name, int seats, int rangeKm) {
        CarModel model = CACHE.get(name);
        if (model == null) {
            String slug = name.toLowerCase().replace(' ', '_');
            model = new CarModel(name, "icons/" + slug + ".png", seats, rangeKm, "photos/" + slug + ".jpg");
            CACHE.put(name, model);
            Log.log("CarModelFactory", "створено новий об'єкт моделі: " + name);
        }
        return model;
    }

    public static int getCreatedCount() {
        return CACHE.size();
    }
}
