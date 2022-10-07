package com.stanrehor.model.vehicle.motorcycle;

import com.stanrehor.model.vehicle.Vehicle;

public class MotoGPBike extends Motorcycle {
    private boolean carbonChassis;
    static int counter = 1;

    public MotoGPBike(){
        setId("MotoGP Bike" + counter++);
        setMaxSpeed(330);
        setAverageSpeed(180);
        setAirDynamicGear(false);
        setSpecialAttribute(false);
        setSkillAddMuliplier(1);
        setVehiclePoints(0);
        setWeight(160);
        setDexterity(6);
    }

    @Override
    public Vehicle generateEnemy() {
        return new MotoGPBike();
    }

    @Override
    public boolean getSpecialAttribute() {
        return carbonChassis;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        carbonChassis = specialAttribute;
    }
}
