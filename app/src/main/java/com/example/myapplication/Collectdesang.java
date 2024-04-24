package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Collectdesang extends AppCompatActivity {
    ListView listView;
    CenterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdesang);
        listView = findViewById(R.id.listprincipale);




    }    private ArrayList<Center> getCenters() {
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
