package lab11.facade;

import java.util.Locale;

import lab11.common.Log;

/** Підсистема: блокування коштів на картці. */
public class PaymentService {
    public boolean holdFunds(String driverId, double amountUah) {
        Log.log("PaymentService", String.format(Locale.US,
                "блокую %.2f грн на картці водія %s", amountUah, driverId));
        return true;
    }
}
