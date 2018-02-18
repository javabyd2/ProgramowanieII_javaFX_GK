package com.sda.javafx;

import com.sda.javafx.controller.MainController;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personObservableList
            = FXCollections.observableArrayList();

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public Main(){
        personObservableList.add(new Person("Jan","Kowalski"));
        personObservableList.add(new Person("Jerzy","Nowak"));
        personObservableList.add(new Person("Piotr","Święciński"));
        personObservableList.add(new Person("Przemysław","Kowalski"));
        personObservableList.add(new Person("Tomasz","Jesionowski"));
        personObservableList.add(new Person("Adam","Mors"));
        personObservableList.add(new Person("Monika","Jasińska"));
        personObservableList.add(new Person("Janusz","Maciejewski"));
        personObservableList.add(new Person("Jerzy","Arct"));
        personObservableList.add(new Person("Marek","Opański"));
    }



    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("/RootLayout.fxml"));
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("RootLayout.fxml"));
        //primaryStage.setTitle("Baza użytkowników");
        //primaryStage.setScene(new Scene(root, 600, 400));
        //primaryStage.show();

        this.primaryStage=primaryStage;
        initRootLayout();
        showPersonLayout();
    }

    private void initRootLayout() throws IOException {


        rootLayout = FXMLLoader.load(
                getClass().getClassLoader().getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showPersonLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader()
                        .getResource("PersonOverview.fxml"));
        AnchorPane person = loader.load();
        rootLayout.setCenter(person);

        MainController controller = loader.getController();
        controller.setMain(this);
    }

    public ObservableList<Person> getPersonObservableList() {
        return personObservableList;
    }
}
