package com.stanrehor.model.vehicle.car;

import com.stanrehor.model.vehicle.Vehicle;

public class OpenWheelCar extends Car {
   private boolean adhernce;
   static int counter = 1;

   public OpenWheelCar(){
       setId("Open Wheel Car " + counter++);
       setMaxSpeed(370);
       setAverageSpeed(200);
       setRacingSeat(false);
       setSpoilerUpgrade(false);
       setSpecialAttribute(false);
       setSkillAddMuliplier(1);
       setVehiclePoints(0);
       setWeight(728);
       setDexterity(9);
   }

    @Override
    public Vehicle generateEnemy() {
        return new OpenWheelCar();
    }

    @Override
    public boolean getSpecialAttribute() {
        return adhernce;
    }

    @Override
    public void setSpecialAttribute(boolean specialAttribute) {
        adhernce = specialAttribute;
    }
}
