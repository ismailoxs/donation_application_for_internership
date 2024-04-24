package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompteActivity extends AppCompatActivity {
    private ArrayList<Center> centers;

    EditText name,number,email,groupedesangui,adrees,dernier;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compte);
        name=findViewById(R.id.textView15);
        number=findViewById(R.id.mynumber);
        email=findViewById(R.id.myemail);
        groupedesangui=findViewById(R.id.mysanguin);
        adrees=findViewById(R.id.myadreese);

       String fullname=getIntent().getStringExtra("full");
        String groupe=getIntent().getStringExtra("groupe");
        String adresse=getIntent().getStringExtra("adresse");
        String Email=getIntent().getStringExtra("email");
        String Number=getIntent().getStringExtra("number");
        name.setText(fullname);
        number.setText(Number);
        email.setText(Email);
        groupedesangui.setText(groupe);
        adrees.setText(adresse);
////goood things will happend
    }
}