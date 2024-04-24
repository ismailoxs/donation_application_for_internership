package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            intent=new Intent(Homme1.this, CompteActivity.class);
            startActivity(intent);
        }
    });
    de_sang.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent=new Intent(Homme1.this, groupesanguin.class);
            startActivity(intent);
        }
    });
        collectdesang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Homme1.this, Collectdesang.class);
                startActivity(intent);
            }
        });

    }
}