package com.example.myapplication;

import java.io.Serializable;

public class Address implements Serializable {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

