package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.motorcycle.MotoGPBike;

public class MotoGPRace extends RaceTrack {
    public MotoGPRace() {
        setLength(5.54);
        setLaps(18);
        setElevation(1);
        setGetNumberOfSharpTurns(3);
        setLengthOfStraights(2);
        setNumberOfTurns(12);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new MotoGPBike();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize( "Serialized/MotoGPBike.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car,"Serialized/MotoGPBike.txt");
    }
}
