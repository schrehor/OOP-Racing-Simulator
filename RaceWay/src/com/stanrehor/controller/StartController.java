package com.stanrehor.controller;

import com.stanrehor.exception.NoSavedDataException;
import com.stanrehor.model.player.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.stanrehor.model.player.Account.loadAccount;


public class StartController {
    static ArrayList<Account> accountList = new ArrayList<>();

    @FXML
    void onActionGoCreateAccount(ActionEvent event) throws IOException {
        Parent createAccount = FXMLLoader.load(getClass().getResource("../view/create_account.fxml"));
        Scene createAccountScene = new Scene(createAccount);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("RaceWay");
        stage.setScene(createAccountScene);
        stage.show();
    }

    @FXML
    void onActionLoadAccount(ActionEvent event) throws IOException {
        try {
            Account account = loadAccount();
            accountList.add(0,account);
            if (account == null){
                throw new NoSavedDataException("You don't have any saved data. Please create a new account.");
            }

            moveAfterFinishedAccount(event);

        }catch (NoSavedDataException e){
            //errorStage(e);
        }
    }

    public void moveAfterFinishedAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/pick_race_view.fxml"));
        Parent pickRace = loader.load();
        Scene pickRaceScene = new Scene(pickRace);

        Stage stage = new Stage();
        stage.setTitle("RaceWay");
        stage.setScene(pickRaceScene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage currentStage  = (Stage) source.getScene().getWindow();
        currentStage.close();
    }

//    public void errorStage(Exception e) throws IOException {
//        ErrorController errorController = new ErrorController();
//        errorController.errorSession(e.getMessage());
//    }






}
