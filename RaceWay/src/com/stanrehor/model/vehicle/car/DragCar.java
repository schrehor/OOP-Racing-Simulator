package com.stanrehor.model.vehicle.car;

import com.stanrehor.model.vehicle.Vehicle;

public class DragCar extends Car {
    private boolean no2;
    static int counter = 1;

    public DragCar(){
        setId("Drag Car " + counter++);
        setMaxSpeed(539);
        setAverageSpeed(getMaxSpeed());
        setRacingSeat(false);
        setSpoilerUpgrade(false);
        setSpecialAttribute(false);
        setSkillAddMuliplier(1);
        setVehiclePoints(0);
        setWeight(1056);
        setDexterity(0);
    }

    @Override
    public Vehicle generateEnemy() {
        return new DragCar();
    }

    @Override
    public boolean getSpecialAttribute() {
        return no2;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        no2 = specialAttribute;
    }
}
