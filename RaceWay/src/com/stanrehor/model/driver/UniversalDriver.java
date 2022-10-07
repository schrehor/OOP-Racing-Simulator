package com.stanrehor.model.driver;

import com.stanrehor.model.race.*;

public class UniversalDriver extends Driver {
    private int vehicleAdaptation;

    public  UniversalDriver(String nickName){
        super(nickName);
    }


    @Override
    public int getSpecialAttribute() {
        return vehicleAdaptation;
    }

    @Override
    public void setSpecialAttribute(int specialAttribute) {
        setDriverPoints(getDriverPoints() - 1);
        vehicleAdaptation += specialAttribute;
    }

    @Override
    public RaceTrack pickRace(String string) {
        RaceTrack race = null;

        switch (string){
            case "1. Open Wheel Race":
                race = pickOpenWheel();
                break;
            case "2. Sports Car Race":
                race = pickSportRace();
                break;
            case "3. Drag Race":
                race = pickDragRace();
                break;
            case "4. Rally Race":
                race = pickRallyRace();
                break;
            case "5. MotoGP Race":
                race = pickMotoGP();
                break;
            case "6. Motocross Race":
                race = pickMotoCross();
                break;
        }

        return race;
    }

    public RaceTrack pickOpenWheel(){
        return new OpenWheelRace();
    }

    public RaceTrack pickSportRace(){
        return new SportsRace();
    }

    public RaceTrack pickRallyRace(){
        return new RallyRace();
    }

    public RaceTrack pickDragRace(){
        return new DragRace();
    }

    public RaceTrack pickMotoGP(){
        return new MotoGPRace();
    }

    public RaceTrack pickMotoCross(){
        return new MotoCrossRace();
    }

    @Override
    public String toString() {
        return "UniversalDriver{" +
                "distanceTravelled=" + getDistanceTravelled() +
                ", vehicleControl=" + getVehicleControl() +
                ", charisma=" + getCharisma() +
                ", trackKnowledge=" + getTrackKnowledge() +
                ", drivingSkill=" + getDrivingSkill() +
                ", numberOfWins=" + getNumberOfWins() +
                ", id='" + getId() + '\'' +
                "vehicleAdaptation=" + vehicleAdaptation +
                '}';
    }
}
