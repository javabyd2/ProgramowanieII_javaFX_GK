package com.sda.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private MenuItem aboutMe;

    public void oMnie(ActionEvent actionEvent) throws IOException {

        Parent menuLayout = FXMLLoader.load(
                getClass().getClassLoader().getResource("About.fxml"));
        Stage stage = new Stage();
        //Scene scene = new Scene(menuLayout);
        stage.setScene(new Scene(menuLayout));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)actionEvent.getSource()).getScene().getWindow() );
        stage.show();




    }
}
