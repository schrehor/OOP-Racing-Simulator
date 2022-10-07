package com.stanrehor.model.vehicle.car;

import com.stanrehor.model.vehicle.Vehicle;

public class SportsCar extends Car {
    private boolean secondTurbo;
    static int counter = 1;

    public SportsCar(){
        setId("Sports Car " + counter++);
        setMaxSpeed(280);
        setAverageSpeed(140);
        setRacingSeat(false);
        setSpoilerUpgrade(false);
        setSpecialAttribute(false);
        setSkillAddMuliplier(1);
        setVehiclePoints(0);
        setWeight(900);
        setDexterity(7);
    }

    @Override
    public Vehicle generateEnemy() {
        return new SportsCar();
    }

    @Override
    public boolean getSpecialAttribute() {
        return secondTurbo;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        secondTurbo = specialAttribute;
    }
}
