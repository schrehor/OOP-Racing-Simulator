package com.stanrehor.model.vehicle.car;

import com.stanrehor.model.vehicle.Vehicle;

abstract public class Car extends Vehicle {
    private boolean racingSeat;
    private boolean spoilerUpgrade;

    public boolean isRacingSeat() {
        return racingSeat;
    }

    public void setRacingSeat(boolean racingSeat) {
        this.racingSeat = racingSeat;
    }

    public boolean isSpoilerUpgrade() {
        return spoilerUpgrade;
    }

    public void setSpoilerUpgrade(boolean spoilerUpgrade) {
        this.spoilerUpgrade = spoilerUpgrade;
    }
}
