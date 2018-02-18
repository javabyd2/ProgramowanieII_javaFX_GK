package com.sda.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class Person {

    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty postalcode;
    private StringProperty city;
    private StringProperty street;
    private StringProperty birthday;
    private LocalDate date;

    public Person(String firstname, String lastname) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getPostalcode() {
        if(postalcodeProperty()!=null)
            return postalcode.get();
        return null;
    }

    public StringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
    }

    public String getCity() {
        if(cityProperty()!=null)
            return city.get();
        return null;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        if (streetProperty()!=null)
            return street.get();
        return null;
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getBirthday() {
        if(birthdayProperty()!=null)
            return birthday.get().toString();
        return null;
    }

    public StringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public Person(String firstname, String lastname,
                  String postalcode, String city,
                  String street, LocalDate date) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.postalcode = new SimpleStringProperty(postalcode);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
       // this.date = new LocalDate(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
