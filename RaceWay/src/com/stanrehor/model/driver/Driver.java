package com.stanrehor.model.driver;

import com.stanrehor.model.race.RaceTrack;

public abstract class Driver extends DriverBlueprint {
    private String nickName;

    public  Driver(String nickName){
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public abstract RaceTrack pickRace(String string);
    public abstract int getSpecialAttribute();
    public abstract void setSpecialAttribute(int specialAttribute);
}

