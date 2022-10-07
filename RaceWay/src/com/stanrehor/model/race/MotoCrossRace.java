package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.motorcycle.MotoCrossBike;

public class MotoCrossRace extends RaceTrack {
    public MotoCrossRace() {
        vehicle = new MotoCrossBike();
        setLength(5);
        setLaps(10);
        setElevation(6);
        setGetNumberOfSharpTurns(4);
        setLengthOfStraights(0.3);
        setNumberOfTurns(30);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new MotoCrossBike();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize("Serialized/MotoCrossBike.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car, "Serialized/MotoCrossBike.txt");
    }
}
