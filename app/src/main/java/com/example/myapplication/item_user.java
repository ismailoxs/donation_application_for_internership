package com.example.myapplication;//package com.example.inter_pro;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.ArrayList;
//
//public class item_user extends BaseAdapter {
//    private Context context;
//    private ArrayList<Center> centers;
//
//    public item_user(Context context, ArrayList<Center> centers) {
//        this.context = context;
//        this.centers = centers;
//    }
//
//    @Override
//    public int getCount() {
//        return centers.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return centers.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.activity_item_user, null);
//            }
//
//            TextView le_centre = convertView.findViewById(R.id.lecentre);
//            TextView adresse = convertView.findViewById(R.id.adresse);
//            TextView numero_telephone = convertView.findViewById(R.id.numerotelephone);
//
//            Center center = centers.get(position);
//
//            le_centre.setText(center.getLe_centre());
//            adresse.setText(center.getAdresse());
//            numero_telephone.setText(center.getNumero_telephone());
//
//            return convertView;
//
//    }
//
//
//}