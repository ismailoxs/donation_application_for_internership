package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CompteActivity extends AppCompatActivity {
    private ArrayList<Center> centers;

    TextView name,number,email,groupedesangui,adrees,dernier;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compte);
        name=findViewById(R.id.textView15);
        number=findViewById(R.id.mynumber);
        email=findViewById(R.id.myemail);
        imageView=findViewById(R.id.imageView);
        groupedesangui=findViewById(R.id.mysanguin);
        adrees=findViewById(R.id.myadreese);

       String fullname=getIntent().getStringExtra("full");
        String groupe=getIntent().getStringExtra("group");
        String adresse=getIntent().getStringExtra("address");
        String Email=getIntent().getStringExtra("email");
        String Number=getIntent().getStringExtra("number");
        String imageUrl = getIntent().getStringExtra("image");

// Load the image into the ImageView using Picasso
        Picasso.get().load(imageUrl).into(imageView);
        name.setText(fullname);
        number.setText(Number);
        email.setText(Email);
        groupedesangui.setText(groupe);
        adrees.setText(adresse);
    }
}