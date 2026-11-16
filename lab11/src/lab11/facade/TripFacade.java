package lab11.facade;

import lab11.common.Log;

/**
 * Facade: уся послідовність початку поїздки описана тут і більше ніде.
 * Застосунок і диспетчер викликають лише startTrip().
 */
public class TripFacade {
    private static final double DEPOSIT_UAH = 500.0;

    private final DriverLicenseService license;
    private final PaymentService payment;
    private final CarReservationService reservation;
    private final DoorLockService doorLock;
    private final TelematicsService telematics;
    private final InsuranceService insurance;

    public TripFacade(DriverLicenseService license, PaymentService payment,
                      CarReservationService reservation, DoorLockService doorLock,
                      TelematicsService telematics, InsuranceService insurance) {
        this.license = license;
        this.payment = payment;
        this.reservation = reservation;
        this.doorLock = doorLock;
        this.telematics = telematics;
        this.insurance = insurance;
    }

    public boolean startTrip(String driverId, String carId) {
        Log.log("TripFacade", "початок поїздки: водій " + driverId + ", авто " + carId);
        if (!license.verify(driverId)) {
            Log.log("TripFacade", "поїздку скасовано: посвідчення недійсне");
            return false;
        }
        if (!payment.holdFunds(driverId, DEPOSIT_UAH)) {
            Log.log("TripFacade", "поїздку скасовано: не вдалося заблокувати кошти");
            return false;
        }
        reservation.reserve(carId, driverId);
        doorLock.unlock(carId);
        telematics.enable(carId);
        insurance.insureTrip(driverId, carId);
        Log.log("TripFacade", "поїздку розпочато");
        return true;
    }
}
