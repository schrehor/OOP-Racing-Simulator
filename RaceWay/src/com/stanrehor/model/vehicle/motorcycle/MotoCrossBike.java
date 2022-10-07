package com.stanrehor.model.vehicle.motorcycle;

import com.stanrehor.model.vehicle.Vehicle;

public class MotoCrossBike extends Motorcycle {
    private boolean customTires;
    static int counter = 1;

    public MotoCrossBike(){
        setId("Motocross Bike " + counter++);
        setMaxSpeed(140);
        setAverageSpeed(80);
        setAirDynamicGear(false);
        setSpecialAttribute(false);
        setSkillAddMuliplier(1);
        setVehiclePoints(0);
        setWeight(98);
        setDexterity(1);
    }

    @Override
    public Vehicle generateEnemy() {
        return new MotoCrossBike();
    }

    @Override
    public boolean getSpecialAttribute() {
        return customTires;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        customTires = specialAttribute;
    }
}
