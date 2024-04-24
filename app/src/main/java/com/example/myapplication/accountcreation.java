package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class accountcreation extends AppCompatActivity {

    private Button signup;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountcreation);

        signup = findViewById(R.id.buttonsignup);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve email and password entered by the user
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Send a POST request to the API endpoint to create a new account
                createUser(email, password);
            }
        });
    }

    private void createUser(String email, String password) {
        // Create a JSON object with user data
        JSONObject userData = new JSONObject();
        try {
            userData.put("email", email);
            userData.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Send a POST request to the API endpoint with user data
        String apiUrl = "https://dummyjson.com/users/add";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, apiUrl, userData, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle successful response from the API
                        // Display success message to the user
                        Toast.makeText(accountcreation.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                        // Optionally, you can navigate to the login activity here
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error response from the API
                        // Display error message to the user
                        Toast.makeText(accountcreation.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Add the request to the RequestQueue
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
