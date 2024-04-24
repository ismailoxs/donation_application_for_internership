package com.example.myapplication;

import android.provider.ContactsContract;
import android.widget.ImageButton;

public class Center {
    private String adresse;
    private String le_centre;
    private String numero_telephone;

    public Center(String le_centre, String adresse, String numero_telephone) {
        this.le_centre = le_centre;
        this.adresse = adresse;
        this.numero_telephone = numero_telephone;
    }

    public String getLe_centre() {
        return le_centre;
    }

    public void setLe_centre(String le_centre) {
        this.le_centre = le_centre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }
}
