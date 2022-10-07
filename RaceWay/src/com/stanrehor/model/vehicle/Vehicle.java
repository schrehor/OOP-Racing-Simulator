package com.stanrehor.model.vehicle;

import java.io.Serializable;

abstract public class Vehicle implements GenerateEnemy,VehicleInterface, Serializable {
    private int VehiclePoints;
    private String id;
    private int maxSpeed;
    private double averageSpeed;
    private int weight;
    private int dexterity;
    private int skillAddMuliplier;

    public int getVehiclePoints() {
        return VehiclePoints;
    }

    public void setVehiclePoints(int vehiclePoints) {
        VehiclePoints += vehiclePoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getSkillAddMuliplier() {
        return skillAddMuliplier;
    }

    public void setSkillAddMuliplier(int skillAddMuliplier) {
        this.skillAddMuliplier = skillAddMuliplier;
    }


}
