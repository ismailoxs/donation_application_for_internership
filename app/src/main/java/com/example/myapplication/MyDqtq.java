package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class MyDqtq implements Serializable {
    @SerializedName("users")
    List <User> Data ;

}
