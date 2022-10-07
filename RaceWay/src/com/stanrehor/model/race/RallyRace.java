package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.car.RallyCar;

public class RallyRace extends RaceTrack {
    public RallyRace() {
        vehicle = new RallyCar();
        setLength(40);
        setLaps(1);
        setElevation(10);
        setGetNumberOfSharpTurns(8);
        setLengthOfStraights(4);
        setNumberOfTurns(59);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new RallyCar();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize( "Serialized/RallyCar.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car, "Serialized/RallyCar.txt");
    }
}
