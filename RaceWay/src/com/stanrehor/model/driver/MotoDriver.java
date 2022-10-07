package com.stanrehor.model.driver;

import com.stanrehor.model.race.*;

public class MotoDriver extends Driver {
    private int stability;

    public  MotoDriver(String nickName){
        super(nickName);
        stability = 0;
    }


    @Override
    public int getSpecialAttribute() {
        return stability;
    }

    @Override
    public void setSpecialAttribute(int specialAttribute) {
        setDriverPoints(getDriverPoints() - 1);
        stability += specialAttribute;
    }

    @Override
    public RaceTrack pickRace(String string) {
        RaceTrack race = null;

        switch (string){
            case "1. MotoGP Race":
                race = pickMotoGP();
                break;
            case "2. Motocross Race":
                race = pickMotoCross();
                break;
        }

        return race;
    }

    public RaceTrack pickMotoGP(){
        return new MotoGPRace();
    }

    public RaceTrack pickMotoCross(){
        return new MotoCrossRace();
    }
}
