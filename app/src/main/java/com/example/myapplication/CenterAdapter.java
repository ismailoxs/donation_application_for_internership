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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CenterAdapter extends RecyclerView.Adapter<CenterAdapter.CenterViewHolder> {
    private ArrayList<Center> centers;
    private LayoutInflater inflater;
    private Context context;

    public CenterAdapter(Context context, ArrayList<Center> centers) {
        this.context = context;
        this.centers = centers;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_item_user, parent, false);
        return new CenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CenterViewHolder holder, int position) {
        Center center = centers.get(position);
        holder.centralinfo.setText(center.getLe_centre());
        holder.adreeseinfo.setText(center.getAdresse());
        holder.phoneinfo.setText(center.getNumero_telephone());
    }

    @Override
    public int getItemCount() {
        return centers.size();
    }

    public class CenterViewHolder extends RecyclerView.ViewHolder {
        TextView centralinfo;
        TextView adreeseinfo;
        TextView phoneinfo;
        ImageButton map;
        ImageButton call;

        public CenterViewHolder(@NonNull View itemView) {
            super(itemView);
            centralinfo = itemView.findViewById(R.id.lecentre);
            adreeseinfo = itemView.findViewById(R.id.adresse);
            phoneinfo = itemView.findViewById(R.id.numerotelephone);
            map = itemView.findViewById(R.id.map);
            call = itemView.findViewById(R.id.call);

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Center center = centers.get(position);
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + center.getNumero_telephone()));
                        if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 123);
                            return;
                        }
                        v.getContext().startActivity(intent);
                    }
                }
            });

            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Center center = centers.get(position);
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + center.getAdresse());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        if (mapIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
                            v.getContext().startActivity(mapIntent);
                        } else {
                            Toast.makeText(v.getContext(), "No application can handle this action", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });


        }
    }
}



