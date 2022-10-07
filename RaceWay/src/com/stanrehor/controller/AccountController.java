package com.stanrehor.controller;

import com.stanrehor.exception.EmptyInputException;
import com.stanrehor.exception.WrongInput;
import com.stanrehor.model.player.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.stanrehor.controller.StartController.accountList;
import static com.stanrehor.model.player.Account.createAccount;


public class AccountController {
    @FXML private Button move;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField age;
    @FXML private TextField ingameName;
    @FXML private RadioButton car;
    @FXML private RadioButton bike;
    @FXML private RadioButton universal;

    @FXML
    void onActionCreateAccount(ActionEvent event) throws IOException {
        String buttonChecked = null;
        if (car.isSelected()){
            buttonChecked = car.getId();
        } else if (bike.isSelected()){
            buttonChecked = bike.getId();
        }else if (universal.isSelected()){
            buttonChecked = universal.getId();
        }

        try {
            if (firstName.getText().equals("") || lastName.getText().equals("") || age.getText().equals("") || ingameName.getText().equals("")) {
                throw new EmptyInputException("Please fill all input areas.");
            }
            if (!age.getText().toString().matches("\\d+")){
                throw new WrongInput("Wrong input type.");
            }

            Account account = createAccount(firstName.getText(), lastName.getText(),
                    Integer.parseInt(age.getText()), ingameName.getText(), buttonChecked);

            accountList.add(0,account);

            goToDriverController(event, account);

        }catch (EmptyInputException e){
            StartController startController = new StartController();
            //startController.errorStage(e);
        } catch (WrongInput wrongInput) {
            StartController startController = new StartController();
            //startController.errorStage(wrongInput);
        }
    }
    @FXML
    public void goToDriverController(ActionEvent event, Account account) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/driver_skill_points_view.fxml"));
        Parent driverSkill = (Parent) loader.load();
        Scene driverSkillScene = new Scene(driverSkill);

        DriverSkillController driverSkillController = loader.getController();
        driverSkillController.getNumberLabel(account.driver.getDriverPoints());

        Stage stage = new Stage();
        stage.setTitle("RaceWay");
        stage.setScene(driverSkillScene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage currentStage  = (Stage) source.getScene().getWindow();
        currentStage.close();
    }


}
