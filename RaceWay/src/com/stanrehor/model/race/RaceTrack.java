package com.stanrehor.model.race;

import com.stanrehor.model.vehicle.Vehicle;

public abstract class RaceTrack implements PickVehicle{
    public Vehicle vehicle;
    private double length;
    private int laps;
    private int numberOfTurns;
    private int getNumberOfSharpTurns;
    private double lengthOfStraights;
    private double elevation;
    private int trackId;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getGetNumberOfSharpTurns() {
        return getNumberOfSharpTurns;
    }

    public void setGetNumberOfSharpTurns(int getNumberOfSharpTurns) {
        this.getNumberOfSharpTurns = getNumberOfSharpTurns;
    }

    public double getLengthOfStraights() {
        return lengthOfStraights;
    }

    public void setLengthOfStraights(double lengthOfStraights) {
        this.lengthOfStraights = lengthOfStraights;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    //public abstract double raceTrackCalculateMove(RaceTrack raceTrack);
}
