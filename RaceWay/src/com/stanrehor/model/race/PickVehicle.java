package com.stanrehor.model.race;

import com.stanrehor.model.vehicle.Vehicle;

public interface PickVehicle {
    Vehicle createVehicle();
    Vehicle loadVehicle();
    void saveVehicle(Vehicle car);
}
