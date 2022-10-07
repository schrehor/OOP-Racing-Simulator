package com.stanrehor.model.driver;

import java.util.Random;

public class EnemyDriver extends DriverBlueprint {
    public EnemyDriver(){
        super();
    }

    public static EnemyDriver makeEnemy(Driver driver){
        EnemyDriver enemy = new EnemyDriver();
        Random rand = new Random();

        enemy.setCharisma(rand.nextInt(driver.getCharisma() + 2));
        enemy.setDrivingSkill(rand.nextInt(driver.getDrivingSkill() + 2));
        enemy.setTrackKnowledge(rand.nextInt(driver.getTrackKnowledge() + 2));
        enemy.setVehicleControl(rand.nextInt(driver.getVehicleControl() + 2));

        return enemy;
    }


}
