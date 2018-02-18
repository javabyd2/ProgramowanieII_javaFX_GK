package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Comparator;
import java.time.LocalDate;


public class MainController {

    @FXML
    private TableView<Person> personTableView;
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

    private Stage primaryStage;

    private Main main;

    public MainController() {
    }

    public void setMain(Main main){
        this.main = main;
        personTableView.setItems(main.getPersonObservableList());
    }

    @FXML
    private void initialize(){

        //personTableView.getItems()
        //        .sorted((o1, o2)->o1.getFirstname().compareTo(o2.getFirstname()))
        //        .comparatorProperty();
        Comparator<Class> comparator = Comparator.comparing(Class::getName);



        firstNameColumn.setCellValueFactory(data -> data.getValue().firstnameProperty());
        lastNameColumn.setCellValueFactory(data->data.getValue().lastnameProperty());

        personTableView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) -> {
            showPerson(newSelection);
            if (newSelection != null) {
                firstNameInput.setText(newSelection.getFirstname());
                lastNameInput.setText(newSelection.getLastname());
                streetNameInput.setText(newSelection.getStreet());
                cityNameInput.setText(newSelection.getCity());
                postalNameInput.setText(newSelection.getPostalcode());
                //dateInput.setText(newSelection.getBirthday());//newSelection.getBirthday()
            }
        });

    } // end of initialize()

    private void showPerson(Person newSelection) {
        System.out.print(newSelection.getFirstname()+",");
        System.out.print(newSelection.getLastname()+",");
        System.out.print(newSelection.getStreet()+",");
        System.out.print(newSelection.getCity()+",");
        System.out.print(newSelection.getPostalcode()+",");
        System.out.print(newSelection.getBirthday()+",");
        System.out.print(newSelection.getDate());
        System.out.println();
    }

    public void deletePerson(ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getSelectedIndex();
        System.out.println(index);
        if(index>-1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("usunięcie");
            alert.setHeaderText("usunęłeś osobę "
                    + personTableView.getItems().get(index).getFirstname()
                    + " "
                    + personTableView.getItems().get(index).getLastname());
            alert.show();
            personTableView.getItems().remove(index);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("błąd");
            alert.setHeaderText("to jest błąd");
            alert.setContentText("należy coś zaznaczyć");
            alert.showAndWait();
        }

    }

    public void updatePerson(ActionEvent actionEvent) {

        int index = personTableView.getSelectionModel().getSelectedIndex();
        System.out.println(index);
        if (index > -1) {
            if (firstNameInput.getText().length() != 0 &&
                    lastNameInput.getText().length() != 0) {
                System.out.println("update");
                personTableView.getItems()
                        .add(new Person(
                                firstNameInput.getText(),
                                lastNameInput.getText(),
                                postalNameInput.getText(),
                                cityNameInput.getText(),
                                streetNameInput.getText(),
                                dateInput.getValue()
                        ));
                personTableView.getItems().remove(index);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("błąd");
                alert.setHeaderText("to jest błąd");
                alert.setContentText("należy coś zaznaczyć");
                alert.showAndWait();
            }
        }
    }

    public void addPerson(ActionEvent actionEvent) {
        personTableView.getItems().add(new Person(
                firstNameInput.getText(),
                lastNameInput.getText(),
                postalNameInput.getText(),
                cityNameInput.getText(),
                streetNameInput.getText(),
                dateInput.getValue()
        ));
    }
}


