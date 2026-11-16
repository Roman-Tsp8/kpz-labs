package lab11.adapter;

import lab11.common.Log;

/** Старий телематичний блок, що вже працює у власному форматі парку (адаптер не потрібен). */
public class NativeTelematicsUnit implements TelematicsUnit {
    private final TelematicsData data;

    public NativeTelematicsUnit(TelematicsData data) {
        this.data = data;
    }

    @Override
    public String carId() {
        return data.carId();
    }

    @Override
    public TelematicsData read() {
        Log.log("NativeTelematicsUnit", "віддає дані авто " + data.carId() + " у власному форматі");
        return data;
    }
}
