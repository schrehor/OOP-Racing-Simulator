package com.stanrehor.model.driver;

import java.io.Serializable;

public abstract class DriverBlueprint implements Serializable {
    transient private double distanceTravelled;
    private int vehicleControl;
    private int charisma;
    private int trackKnowledge;
    private int drivingSkill;
    private int driverPoints;
    private int numberOfWins;
    private String id;
    private static int count = 1;

    public DriverBlueprint(){
        setId("Driver " + count++);
        distanceTravelled = 0;
        vehicleControl = 0;
        charisma = 0;
        trackKnowledge = 0;
        drivingSkill = 0;
        numberOfWins = 0;
        //todo exception na vyuzitie viac pointov ako ma driver
        driverPoints = 20;
    }

    public int getVehicleControl() {
        return vehicleControl;
    }

    public void setVehicleControl(int vehicleControl) {
        driverPoints -= vehicleControl;
        this.vehicleControl += vehicleControl;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        driverPoints -= charisma;
        this.charisma += charisma;
    }

    public int getTrackKnowledge() {
        return trackKnowledge;
    }

    public void setTrackKnowledge(int trackKnowledge) {
        driverPoints -= trackKnowledge;
        this.trackKnowledge += trackKnowledge;
    }

    public int getDrivingSkill() {
        return drivingSkill;
    }

    public void setDrivingSkill(int drivingSkill) {
        driverPoints -= drivingSkill;
        this.drivingSkill += drivingSkill;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins() {
        this.numberOfWins += 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled += distanceTravelled;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    //public abstract double driverCalculateMove(Driver drive);
}

