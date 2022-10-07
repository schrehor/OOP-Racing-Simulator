package com.stanrehor.model.driver;

import com.stanrehor.model.race.*;

public class CarDriver extends Driver{
    private int shiftSkill;

    public CarDriver(String nickName){
        super(nickName);
        shiftSkill = 0;
    }

    @Override
    public int getSpecialAttribute() {
        return shiftSkill;
    }

    @Override
    public void setSpecialAttribute(int specialAttribute) {
        setDriverPoints(getDriverPoints() - 1);
        shiftSkill += specialAttribute;
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
}
