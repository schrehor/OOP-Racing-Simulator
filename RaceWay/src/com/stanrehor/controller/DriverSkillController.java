package com.stanrehor.controller;

import com.stanrehor.model.player.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static com.stanrehor.controller.StartController.accountList;

public class DriverSkillController {

    private Account account = accountList.get(0);

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @FXML
    Label infoLabel;
    @FXML
    Label vehicleControl;
    @FXML
    Label trackKnowledge;
    @FXML
    Label specialAttribute;
    @FXML
    Label charisma;
    @FXML
    Label drivingSkills;
    @FXML
    Button nextStage;
    @FXML
    Button trackAdd;
    @FXML
    Button drivingAdd;
    @FXML
    Button vehicleAdd;
    @FXML
    Button specialAdd;
    @FXML
    Button charismaAdd;

    public void getNumberLabel(int count){
        infoLabel.setText("You have " + count + " points to spend on your Driver.");
    }

    @FXML
    void onActionAddVehicleControl(){
        account.driver.setVehicleControl(1);
        vehicleControl.setText(String.valueOf(account.driver.getVehicleControl()));
        infoLabel.setText("You have " + account.driver.getDriverPoints() + " points to spend on your Driver.");
        showButton(account);
    }

    @FXML
    void onActionAddTrackKnowledge(){
        account.driver.setTrackKnowledge(1);
        trackKnowledge.setText(String.valueOf(account.driver.getTrackKnowledge()));
        infoLabel.setText("You have " + account.driver.getDriverPoints() + " points to spend on your Driver.");
        showButton(account);
    }

    @FXML
    void onActionAddSpecialAttribute(){
        account.driver.setSpecialAttribute(1);
        specialAttribute.setText(String.valueOf(account.driver.getSpecialAttribute()));
        infoLabel.setText("You have " + account.driver.getDriverPoints() + " points to spend on your Driver.");
        showButton(account);
    }

    @FXML
    void onActionAddCharisma(){
        account.driver.setCharisma(1);
        charisma.setText(String.valueOf(account.driver.getCharisma()));
        infoLabel.setText("You have " + account.driver.getDriverPoints() + " points to spend on your Driver.");
        showButton(account);
    }

    @FXML
    void onActionAddDrivingSkills(){
        account.driver.setDrivingSkill(1);
        drivingSkills.setText(String.valueOf(account.driver.getDrivingSkill()));
        infoLabel.setText("You have " + account.driver.getDriverPoints() + " points to spend on your Driver.");
        showButton(account);
    }

    void showButton(Account account){
        if (account.driver.getDriverPoints() == 0){
            nextStage.setVisible(true);
            trackAdd.setDisable(true);
            drivingAdd.setDisable(true);
            vehicleAdd.setDisable(true);
            specialAdd.setDisable(true);
            charismaAdd.setDisable(true);
        }
    }

    @FXML
    void onActionMovePickRace(ActionEvent event) throws IOException {
        StartController startController = new StartController();
        startController.moveAfterFinishedAccount(event);
    }
}
