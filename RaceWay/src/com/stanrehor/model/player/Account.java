package com.stanrehor.model.player;

import com.stanrehor.model.driver.CarDriver;
import com.stanrehor.model.driver.Driver;
import com.stanrehor.model.driver.MotoDriver;
import com.stanrehor.model.driver.UniversalDriver;
import com.stanrehor.model.save.Save;

import java.io.Serializable;

public class Account implements Serializable {
    public Driver driver;
    private String firstName;
    private String lastName;
    private int age;
    private int idPlayer;
    static int counter = 1;

    public Account(String firstName, String lastName, int age, Driver driver){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.driver = driver;
        idPlayer = counter++;
    }

    public Account(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "driver=" + driver +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", idPlayer=" + idPlayer +
                '}';
    }

    public static Account loadAccount(){
        Save<Account> save = new Save<>();
        return save.deserialize("Serialized/Account.txt");
    }

    public static void saveAccount (Account account){
        Save<Account> save = new Save<>();
        save.serialize(account, "Serialized/Account.txt");
    }

    public static Account createAccount(String firstName, String lastName, int age, String gameName, String type){
        switch (type){
            case "car":
                return new Account(firstName,lastName,age,new CarDriver(gameName));
            case "bike":
                return new Account(firstName,lastName,age,new MotoDriver(gameName));
            case "universal":
                return new Account(firstName,lastName,age,new UniversalDriver(gameName));
            default:
                return null;
        }
    }
}
