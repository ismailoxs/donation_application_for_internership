package com.example.myapplication;

import java.io.Serializable;


public class User implements Serializable {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String bloodGroup;
    private Address address;
    private String phone;

    public String getImage() {
        return image;
    }

    private String image;


    public User(String email, String password, String bloodGroup, Address address, String phone,String firstName,String lastName,String image) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName=lastName;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.phone = phone;
        this.image=image;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String Fullname() {
        return getFirstName() + " "+ getLastName();
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLasttName(String lasttName) {
        this.lastName = lasttName;
    }}
