package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;


public class Collectdesang extends AppCompatActivity {
    RecyclerView recyclerView;
    CenterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdesang);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CenterAdapter(this, getCenters());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Center> getCenters() {
        ArrayList<Center> centers = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("centers.json");
            int code;
            StringBuilder stringBuilder = new StringBuilder();
            String jsonstring;
            code = inputStream.read();
            while (code != -1) {
                stringBuilder.append((char) code);
                code = inputStream.read();
            }
            jsonstring = stringBuilder.toString();
            JSONObject jsonObject = new JSONObject(jsonstring);
            JSONArray jsonArray = jsonObject.getJSONArray("centers");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject centerJson = jsonArray.getJSONObject(i);
                centers.add(new Center(
                        centerJson.getString("le_centre"),
                        centerJson.getString("adresse"),
                        centerJson.getString("numero_telephone")
                ));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return centers;
    }
}


