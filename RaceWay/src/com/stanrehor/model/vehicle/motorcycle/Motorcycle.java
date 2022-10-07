package com.stanrehor.model.vehicle.motorcycle;

import com.stanrehor.model.vehicle.Vehicle;

abstract public class Motorcycle extends Vehicle {
    protected boolean airDynamicGear;
    
    public boolean isAirDynamicGear() {
        return airDynamicGear;
    }

    public void setAirDynamicGear(boolean airDynamicGear) {
        this.airDynamicGear = airDynamicGear;
    }




}
