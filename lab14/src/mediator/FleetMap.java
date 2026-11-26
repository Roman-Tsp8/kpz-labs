package mediator;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/** ConcreteColleague: карта парку (які авто зараз видно клієнтам). */
public class FleetMap extends DispatchService {
    private final Set<String> carsOnMap = new LinkedHashSet<>();

    public FleetMap(DispatchMediator mediator, Collection<String> initialCars) {
        super(mediator, "FleetMap");
        carsOnMap.addAll(initialCars);
    }

    public void removeCar(String carId) {
        carsOnMap.remove(carId);
        log(carId + " прибрано з карти, на карті: " + carsOnMap);
    }

    public void returnCar(String carId) {
        carsOnMap.add(carId);
        log(carId + " повернено на карту, на карті: " + carsOnMap);
    }
}
