package lab11.proxy;

/** Subject: інтерфейс команд авто. Застосунок працює лише з ним. */
public interface CarCommands {
    void openDoors(String clientId);

    void startEngine(String clientId);

    void honk(String clientId);
}
