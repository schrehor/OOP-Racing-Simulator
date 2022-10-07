package com.stanrehor.controller;

import com.stanrehor.model.driver.CarDriver;
import com.stanrehor.model.driver.MotoDriver;
import com.stanrehor.model.driver.UniversalDriver;
import com.stanrehor.model.player.Account;
import com.stanrehor.model.race.RaceTrack;
import com.stanrehor.model.vehicle.Vehicle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.stanrehor.controller.StartController.accountList;

public class PickRaceController {
    static ArrayList<RaceTrack> track = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Account account = accountList.get(0);
    private RaceTrack raceTrack;
    @FXML
    ComboBox pickRaceCombo;
    @FXML
    Button loadBtn;
    @FXML
    Button createBtn;


    @FXML
    public void onActionFillComboBox(){
        account.saveAccount(account);

        if (account.driver instanceof CarDriver){
            pickRaceCombo.setItems(FXCollections.observableArrayList(
                    new String("1. Open Wheel Race"),
                    new String("2. Sports Car Race"),
                    new String("3. Drag Race"),
                    new String("4. Rally Race")
            ));
        } else if (account.driver instanceof MotoDriver){
            pickRaceCombo.setItems(FXCollections.observableArrayList(
                    new String("1. MotoGP Race"),
                    new String("2. Motocross Race")
            ));
        } else if (account.driver instanceof UniversalDriver){
            pickRaceCombo.setItems(FXCollections.observableArrayList(
                    new String("1. Open Wheel Race"),
                    new String("2. Sports Car Race"),
                    new String("3. Drag Race"),
                    new String("4. Rally Race"),
                    new String("5. MotoGP Race"),
                    new String("6. Motocross Race")
            ));
        }
    }

    @FXML
    public void onActionPickRace(){
        if (!pickRaceCombo.getSelectionModel().isEmpty())
        {
            raceTrack = account.driver.pickRace((String) pickRaceCombo.getValue());
            track.add(0,raceTrack);
            loadBtn.setVisible(true);
            createBtn.setVisible(true);
        }
    }

    @FXML
    public void onActionCreateNewV(ActionEvent e) throws IOException {
        Vehicle vehicle = raceTrack.createVehicle();
        vehicles.add(0,vehicle);
        raceTrack.saveVehicle(vehicle);

        createRaceScene(e);
    }

    @FXML
    public void onActionLoadV(ActionEvent e) throws IOException {
        Vehicle vehicle = raceTrack.loadVehicle();
        vehicles.add(0,vehicle);

        createRaceScene(e);
    }

    public void createRaceScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/race_view.fxml"));
        Parent race = loader.load();
        Scene raceScene = new Scene(race);

        Stage stage = new Stage();
        stage.setTitle("RaceWay");
        stage.setScene(raceScene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage currentStage  = (Stage) source.getScene().getWindow();
        currentStage.close();
    }
}
