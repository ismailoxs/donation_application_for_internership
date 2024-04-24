package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
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
    ImageView imageView11,imageView12,companyicon;
    LinearLayout linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.userID);
        code = findViewById(R.id.codeID);
        submitButton = findViewById(R.id.submitButton);
        creationAccount = findViewById(R.id.buttoncreationaccount);
        companyicon=findViewById(R.id.companyicon);
        imageView12=findViewById(R.id.imageView12);
        imageView11=findViewById(R.id.imageView11);
        linearLayout2=findViewById(R.id.linearLayout2);
        companyicon.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                companyicon.setVisibility(View.INVISIBLE);
                // Show other items after 3 seconds
                submitButton.setVisibility(View.VISIBLE);
                creationAccount.setVisibility(View.VISIBLE);
                user.setVisibility(View.VISIBLE);
                code.setVisibility(View.VISIBLE);
                imageView12.setVisibility(View.VISIBLE);
                imageView11.setVisibility(View.VISIBLE);
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

        creationAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, accountcreation.class);
                startActivity(intent);
            }
        });
    }

    private void Verification(VerificationCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> users = response.body();
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
                    callback.onVerificationResult(success, verifiedUser);
                } else {
                    // Handle unsuccessful response or null body
                    callback.onVerificationResult(false, null);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onVerificationResult(false, null);
            }
        });
    }

    interface VerificationCallback {
        void onVerificationResult(boolean success, User verifiedUser);
    }
}
