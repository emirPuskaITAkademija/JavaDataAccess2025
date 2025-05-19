package com.itakademija.hr.person;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.StringJoiner;

public class PersonEntity implements Serializable {

    //anotacija iz google GSON biblioteke
    @SerializedName("nin")
    private String nationalIdentificationNumber;
    private String name;
    private String surname;
    private int age;

    public PersonEntity() {
    }

    public PersonEntity(String nationalIdentificationNumber, String name, String surname, int age) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonEntity.class.getSimpleName() + "[", "]")
                .add("nationalIdentificationNumber='" + nationalIdentificationNumber + "'")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("age=" + age)
                .toString();
    }
}
