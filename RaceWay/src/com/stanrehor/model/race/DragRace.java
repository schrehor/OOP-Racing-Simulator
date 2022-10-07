package com.stanrehor.model.race;

import com.stanrehor.model.save.Save;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.car.DragCar;

public class DragRace extends RaceTrack {
    public DragRace() {
        vehicle = new DragCar();
        setLength(0.4);
        setLaps(1);
        setElevation(0);
        setGetNumberOfSharpTurns(0);
        setLengthOfStraights(0.4);
        setNumberOfTurns(0);
        setTrackId(1);
    }

    @Override
    public Vehicle createVehicle() {
        return new DragCar();
    }

    @Override
    public Vehicle loadVehicle() {
        Save<Vehicle> save = new Save<>();
        return save.deserialize("Serialized/DragCar.txt");
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Save<Vehicle> save = new Save<>();
        save.serialize(car,"Serialized/DragCar.txt");
    }
}

