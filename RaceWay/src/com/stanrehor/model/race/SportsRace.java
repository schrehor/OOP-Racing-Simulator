package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.car.SportsCar;

public class SportsRace extends RaceTrack {
    public SportsRace() {
        vehicle = new SportsCar();
        setLength(5.89);
        setLaps(18);
        setElevation(2);
        setGetNumberOfSharpTurns(4);
        setLengthOfStraights(2);
        setNumberOfTurns(18);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new SportsCar();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize("Serialized/SportsCar.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car,"Serialized/SportsCar.txt");
    }
}
