package com.stanrehor.model.vehicle.car;

import com.stanrehor.model.vehicle.Vehicle;

public class RallyCar extends Car {
    private boolean suspension;
    static int counter = 1;

    public RallyCar(){
        setId("Rally Car " + counter++);
        setMaxSpeed(130);
        setAverageSpeed(80);
        setRacingSeat(false);
        setSpoilerUpgrade(false);
        setSpecialAttribute(false);
        setSkillAddMuliplier(1);
        setVehiclePoints(0);
        setWeight(1230);
        setDexterity(6);
    }

    @Override
    public Vehicle generateEnemy() {
        return new RallyCar();
    }

    @Override
    public boolean getSpecialAttribute() {
        return suspension;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        suspension = specialAttribute;
    }
}
