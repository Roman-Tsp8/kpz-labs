package observer;

import common.EventLog;

/** ConcreteObserver: страхова компанія. Реагує лише на удар. */
public class InsuranceCompany implements CarEventListener {

    @Override
    public String getName() {
        return "InsuranceCompany";
    }

    @Override
    public void onCarEvent(CarEvent event) {
        if (event.type() == CarEventType.CRASH) {
            EventLog.log(getName(), event.carId() + ": реєструю страховий випадок");
        }
    }
}
