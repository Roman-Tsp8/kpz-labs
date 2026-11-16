package lab11.proxy;

import lab11.common.Log;

/** RealSubject: передає команди через повільний віддалений сервер виробника (з лімітом викликів). */
public class RemoteCarController implements CarCommands {
    private final String carId;
    private int serverCalls = 0;

    public RemoteCarController(String carId) {
        this.carId = carId;
    }

    public int getServerCalls() {
        return serverCalls;
    }

    @Override
    public void openDoors(String clientId) {
        send("відкрити двері", clientId);
    }

    @Override
    public void startEngine(String clientId) {
        send("увімкнути двигун", clientId);
    }

    @Override
    public void honk(String clientId) {
        send("посигналити", clientId);
    }

    private void send(String command, String clientId) {
        serverCalls++;
        Log.log("RemoteCarController", "ВИКЛИК СЕРВЕРА ВИРОБНИКА: «" + command + "» для авто "
                + carId + " (клієнт " + clientId + "), виклик №" + serverCalls);
    }
}
