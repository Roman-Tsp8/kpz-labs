package ua.miskauto.chain;

/** Запит на допуск до поїздки: клієнт + авто. */
public class TripRequest {
    private final Client client;
    private final Vehicle vehicle;

    public TripRequest(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }

    public Client getClient() { return client; }
    public Vehicle getVehicle() { return vehicle; }

    @Override
    public String toString() { return client.getName() + " → " + vehicle.getModel(); }
}
