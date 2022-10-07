package com.stanrehor.controller;

import com.stanrehor.model.driver.Driver;
import com.stanrehor.model.driver.EnemyDriver;
import com.stanrehor.model.player.Account;
import com.stanrehor.model.race.RaceTrack;
import com.stanrehor.model.vehicle.Vehicle;
import com.stanrehor.model.vehicle.car.DragCar;
import com.stanrehor.model.vehicle.car.OpenWheelCar;
import com.stanrehor.model.vehicle.car.RallyCar;
import com.stanrehor.model.vehicle.car.SportsCar;
import com.stanrehor.model.vehicle.motorcycle.MotoCrossBike;
import com.stanrehor.model.vehicle.motorcycle.MotoGPBike;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static com.stanrehor.controller.PickRaceController.track;
import static com.stanrehor.controller.PickRaceController.vehicles;
import static com.stanrehor.controller.StartController.accountList;
import static com.stanrehor.model.driver.EnemyDriver.makeEnemy;

public class ExecuteRace{
    Vehicle vehicle = vehicles.get(0);
    RaceTrack raceTrack = track.get(0);
    Account account = accountList.get(0);

    @FXML
    ImageView image1;
    @FXML
    ImageView image2;
    @FXML
    ImageView image3;
    @FXML
    ImageView image4;
    @FXML
    Label WinLb;


    @FXML
    void setImage(){
        if (vehicle instanceof MotoCrossBike){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@cross.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@cross.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@cross.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@cross.png")));
        } else if (vehicle instanceof MotoGPBike){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@motogp.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@motogp.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@motogp.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@motogp.png")));
        } else if (vehicle instanceof DragCar){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@drag.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@drag.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@drag.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@drag.png")));
        } else if (vehicle instanceof SportsCar){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@sport.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@sport.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@sport.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@sport.png")));
        } else if (vehicle instanceof OpenWheelCar){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@open.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@open.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@open.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@open.png")));
        } else if (vehicle instanceof RallyCar){
            image1 = new ImageView(new Image(getClass().getResourceAsStream("@rally.png")));
            image2 = new ImageView(new Image(getClass().getResourceAsStream("@rally.png")));
            image3 = new ImageView(new Image(getClass().getResourceAsStream("@rally.png")));
            image4 = new ImageView(new Image(getClass().getResourceAsStream("@rally.png")));
        }


    }


    private static EnemyDriver[] enemy;
    private static Vehicle[] enemyVehicle;

    @FXML
    public void race(){
        boolean flag = false;

        enemyGenerate(account.driver, 3);
        enemyVehicle(vehicle, 3);

        double finalDistance = raceTrack.getLength() * raceTrack.getLaps();

        while (448 >= account.driver.getDistanceTravelled()){
            for (int i = 0; i < 3; i++) {
                if (finalDistance <= enemy[i].getDistanceTravelled()){
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("You have lost, try again.");
                return;
            }

            new Thread(() ->{
                moveDriver(account.driver, raceTrack);
                moveEnemy(enemy[0], raceTrack, enemyVehicle[0]);
                moveEnemy(enemy[1], raceTrack, enemyVehicle[1]);
                moveEnemy(enemy[2], raceTrack, enemyVehicle[2]);
            }).start();

            image1.setLayoutX(image1.getLayoutX() + account.driver.getDistanceTravelled());
            image2.setLayoutX(image2.getLayoutX() + enemy[0].getDistanceTravelled());
            image3.setLayoutX(image3.getLayoutX() + enemy[1].getDistanceTravelled());
            image4.setLayoutX(image4.getLayoutX() + enemy[2].getDistanceTravelled());

            if (image1.getLayoutX() + account.driver.getDistanceTravelled() > 448){
                image1.setLayoutX(430);
                WinLb.setText("I win!");
            }
            if (image2.getLayoutX() +  enemy[0].getDistanceTravelled() > 448){
                image2.setLayoutX(430);
                WinLb.setText("You lose!");
            }
            if (image3.getLayoutX() + enemy[1].getDistanceTravelled() > 448){
                image3.setLayoutX(430);
                WinLb.setText("You lose!");
            }
            if (image4.getLayoutX() + enemy[2].getDistanceTravelled() > 448){
                image4.setLayoutX(430);
                WinLb.setText("You lose!");
            }


        }
        account.driver.setDriverPoints(account.driver.getCharisma() + 1);
        account.driver.setNumberOfWins();
        raceTrack.vehicle.setVehiclePoints(1);
        System.out.println("Congratulations "+ account.driver.getNickName() + " you won! You have gained " + (account.driver.getCharisma() + 1) + " points for you character and "+ raceTrack.vehicle.getVehiclePoints() + " for you car.");
    }

    public static void moveDriver(Driver driver, RaceTrack raceTrack){
        Random rand = new Random();
        double move = (raceTrack.vehicle.getSpecialAttribute()) ? (driver.getDrivingSkill() + driver.getTrackKnowledge() +
                ((raceTrack.getLengthOfStraights()*raceTrack.vehicle.getMaxSpeed() +
                        (raceTrack.getNumberOfTurns() - raceTrack.getGetNumberOfSharpTurns()) *
                                (driver.getTrackKnowledge() + driver.getVehicleControl() + raceTrack.vehicle.getDexterity()) *
                                (raceTrack.vehicle.getAverageSpeed() / 2))
                        % raceTrack.vehicle.getWeight())) % raceTrack.getLaps() + rand.nextInt(5)+1
                :
                (driver.getDrivingSkill() + driver.getTrackKnowledge() +
                        ((raceTrack.getLengthOfStraights()*raceTrack.vehicle.getMaxSpeed() +
                                (raceTrack.getNumberOfTurns() - raceTrack.getGetNumberOfSharpTurns()) *
                                        (driver.getTrackKnowledge() + driver.getVehicleControl() + raceTrack.vehicle.getDexterity()) *
                                        (raceTrack.vehicle.getAverageSpeed() / 2))
                                % raceTrack.vehicle.getWeight())) % raceTrack.getLaps();

        driver.setDistanceTravelled(move);

    }

    public static void moveEnemy(EnemyDriver driver, RaceTrack raceTrack, Vehicle vehicle){
        double move = (driver.getDrivingSkill() +
                ((raceTrack.getLengthOfStraights()*vehicle.getMaxSpeed() +
                        (raceTrack.getNumberOfTurns() - raceTrack.getGetNumberOfSharpTurns()) *
                                (driver.getTrackKnowledge() + driver.getVehicleControl() + vehicle.getDexterity()) *
                                (vehicle.getAverageSpeed() / 2))
                        % vehicle.getWeight())) % raceTrack.getLaps();

        driver.setDistanceTravelled(move);
    }

    public static void enemyVehicle(Vehicle vehicle, int enemyCount){
        enemyVehicle = new Vehicle[enemyCount];
        for (int i = 0; i < enemyCount; i++) {
            enemyVehicle[i] = vehicle.generateEnemy();
        }
    }

    public static void enemyGenerate(Driver driver, int enemyCount){
        enemy = new EnemyDriver[enemyCount];
        for (int i = 0; i < enemyCount; i++) {
            enemy[i] = makeEnemy(driver);
        }
    }
}
