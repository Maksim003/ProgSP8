package com.company.Model;

public class Email {

    private int id;
    private String address;
    private String name;
    private String surname;

    public Email(String address, String name, String surname) {
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    public Email(int id, String address, String name, String surname) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    public Email() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
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
}
