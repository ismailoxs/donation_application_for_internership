package com.example.myapplication;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
public class CenterAdapter extends BaseAdapter {
    private ArrayList<Center> centers;
    private LayoutInflater inflater;
    private Context context;

    public CenterAdapter(Context context, ArrayList<Center> centers) {
        this.context = context;
        this.centers = centers;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return centers.size();
    }

    @Override
    public Object getItem(int position) {
        return centers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_collectdesang, null);

        TextView le_centre = convertView.findViewById(R.id.lecentre);
        TextView adresse = convertView.findViewById(R.id.adresse);
        TextView numero_telephone = convertView.findViewById(R.id.numerotelephone);
        ImageButton map = convertView.findViewById(R.id.map);
        ImageButton call = convertView.findViewById(R.id.call);

        Center center = centers.get(position);

        le_centre.setText(center.getLe_centre());
        adresse.setText(center.getAdresse());
        numero_telephone.setText(center.getNumero_telephone());

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + center.getNumero_telephone()));
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 123);
                    return;
                }
                v.getContext().startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + center.getAdresse());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(mapIntent);
                }
            }
        });

        return convertView;
    }
}


