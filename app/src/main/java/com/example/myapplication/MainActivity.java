package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText code;
    private Button submitButton;
    private Button creationAccount;
    ImageView imageView11, imageView12, companyicon,mobadara;
    LinearLayout linearLayout2;
    TextView loginID, textView3, textView4, textView39;
    View view5, view6;
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.userID);
        code = findViewById(R.id.codeID);
        submitButton = findViewById(R.id.submitButton);
        creationAccount = findViewById(R.id.buttoncreationaccount);
        companyicon = findViewById(R.id.companyicon);
        mobadara=findViewById(R.id.mobadaraimage);
        imageView12 = findViewById(R.id.imageView12);
        imageView11 = findViewById(R.id.imageView11);
        linearLayout2 = findViewById(R.id.linearLayout2);
        loginID = findViewById(R.id.loginID);
        textView4 = findViewById(R.id.textView4);
        textView3 = findViewById(R.id.textView3);
        textView39 = findViewById(R.id.textView39);
        mobadara.setVisibility(View.VISIBLE);
        companyicon.setVisibility(View.INVISIBLE);
        view5 = findViewById(R.id.view5);
        view6 = findViewById(R.id.view6);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.languages_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedLanguage = parent.getItemAtPosition(position).toString();
//                if (selectedLanguage.equals("Français")) {
//                    setLocale("fr");
//                } else if (selectedLanguage.equals("Arabe")) {
//                    setLocale("ar");
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hide the mobadara image
                mobadara.setVisibility(View.INVISIBLE);

                // Show the company icon
                companyicon.setVisibility(View.VISIBLE);

                // Hide the items for 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        companyicon.setVisibility(View.INVISIBLE);
                        // Show the items after 3 seconds
                        submitButton.setVisibility(View.VISIBLE);
                        creationAccount.setVisibility(View.VISIBLE);
                        user.setVisibility(View.VISIBLE);
                        code.setVisibility(View.VISIBLE);
                        imageView12.setVisibility(View.VISIBLE);
                        imageView11.setVisibility(View.VISIBLE);
                        loginID.setVisibility(View.VISIBLE);
                        textView4.setVisibility(View.VISIBLE);
                        textView3.setVisibility(View.VISIBLE);
                        textView39.setVisibility(View.VISIBLE);
//                        spinner.setVisibility(View.VISIBLE);
                        view5.setVisibility(View.VISIBLE);
                        view6.setVisibility(View.VISIBLE);
                    }
                }, 3000); // 3 seconds
            }
        }, 3000); // 3 seconds
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Verification(new VerificationCallback() {
                    @Override
                    public void onVerificationResult(boolean success, User verifiedUser) {
                        if (success) {
                            Intent intent = new Intent(MainActivity.this, Homme1.class);
                            intent.putExtra("user", verifiedUser);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Error: Email or code are not valid", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Verification(new VerificationCallback() {
//                    @Override
//                    public void onVerificationResult(boolean success, User verifiedUser) {
//                        if (success) {
//                            Intent intent = new Intent(MainActivity.this, Homme1.class);
//                            intent.putExtra("user", verifiedUser);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(MainActivity.this, "Error: Email or code are not valid", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });

        creationAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, accountcreation.class);
                startActivity(intent);
            }
        });
    }
//    private void setLocale(String languageCode) {
//        Locale locale = new Locale(languageCode);
//        Locale.setDefault(locale);
//
//        Resources resources = getResources();
//        Configuration configuration = resources.getConfiguration();
//        configuration.setLocale(locale);
//
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//
//        // Restart the activity to apply the new locale
//        recreate();
//    }





    private void Verification(VerificationCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<MyDqtq> call = service.getUsers();

        call.enqueue(new Callback<MyDqtq>() {
            @Override
            public void onResponse(Call<MyDqtq> call, Response<MyDqtq> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> users = response.body().Data;
                    String inputEmail = user.getText().toString();
                    String inputPassword = code.getText().toString();
                    boolean success = false;
                    User verifiedUser = null;
                    for (User user : users) {
                        if (user.getEmail().equals(inputEmail) && user.getPassword().equals(inputPassword)) {
                            success = true;
                            verifiedUser = user;
                            break;
                        }
                    }
                    if (success)
                        callback.onVerificationResult(success, verifiedUser);
                    else
                        callback.onVerificationResult(false, null);

                } else {
                    // Handle unsuccessful response or null body
                    callback.onVerificationResult(false, null);
                }
            }

            @Override
            public void onFailure(Call<MyDqtq> call, Throwable t) {
                callback.onVerificationResult(false, null);
            }
        });
    }


    interface VerificationCallback {
        void onVerificationResult(boolean success, User verifiedUser);
    }
}
