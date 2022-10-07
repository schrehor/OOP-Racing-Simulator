package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.car.OpenWheelCar;

public class OpenWheelRace extends RaceTrack {
    public OpenWheelRace(){
        vehicle = new OpenWheelCar();
        setLength(6);
        setLaps(51);
        setElevation(1);
        setGetNumberOfSharpTurns(2);
        setLengthOfStraights(1.5);
        setNumberOfTurns(14);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new OpenWheelCar();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize( "Serialized/OpenWheelCar.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car, "Serialized/OpenWheelCar.txt");
    }
}
