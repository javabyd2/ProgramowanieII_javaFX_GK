package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;


public class Controller {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextArea streetNameInput;
    @FXML
    private TextField cityNameInput;
    @FXML
    private TextField postalNameInput;
    @FXML
    private DatePicker dateInput;

    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    public void openAboutWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/About.fxml"));
        //stage.setScene(new Scene(root));
        //stage.setTitle("My modal window");
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(
        //        ((Node)event.getSource()).getScene().getWindow() );
        //stage.show();
    }
}

