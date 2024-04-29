package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Homme1 extends AppCompatActivity {
Button compte,consultation,instruction,de_sang,urgence,collectdesang;
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homme1);
    compte=findViewById(R.id.compte);
    consultation=findViewById(R.id.consultation);
    instruction=findViewById(R.id.instruction);
    de_sang=findViewById(R.id.de_sang);
    urgence=findViewById(R.id.urgance);
    collectdesang=findViewById(R.id.collectsang);
        compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User verifiedUser = (User) getIntent().getSerializableExtra("user");
                if (verifiedUser != null) {
                    Intent intent = new Intent(Homme1.this, CompteActivity.class);
                    intent.putExtra("full", verifiedUser.Fullname());
                    intent.putExtra("group", verifiedUser.getBloodGroup());
                    if (verifiedUser.getAddress() != null) {
                        intent.putExtra("address", verifiedUser.getAddress().getAddress());
                    } else {
                        intent.putExtra("address", "Address not available");
                    }
                    intent.putExtra("email", verifiedUser.getEmail());
                    intent.putExtra("number", verifiedUser.getPhone());
                    intent.putExtra("image", verifiedUser.getImage());

                    startActivity(intent);
                } else {
                    // Handle case where user object is null
                    Toast.makeText(Homme1.this, "Error: User information is missing", Toast.LENGTH_SHORT).show();
                }
            }
        });


        de_sang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent = new Intent(Homme1.this, groupesanguin.class);
                        startActivity(intent);
                    }
                });
                collectdesang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent = new Intent(Homme1.this, Collectdesang.class);
                        startActivity(intent);
                    }
                });

            }}