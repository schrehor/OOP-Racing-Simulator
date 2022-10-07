package com.stanrehor.controller;

import com.stanrehor.view.error_view;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ErrorController {
    public static ArrayList<String> error = new ArrayList<>();
    public error_view errorView = null;

    public void errorSession(String string) {
        error.add(0,string);
        new error_view().start(new Stage());
    }

    public void SetupView(error_view errorView) {
        this.errorView = errorView;
    }
}