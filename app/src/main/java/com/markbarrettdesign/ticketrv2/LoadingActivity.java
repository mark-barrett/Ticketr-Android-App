package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Intent intent = getIntent();
        String qrcode = intent.getStringExtra("qrcode");

        // Response received from the server
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        System.out.println("It's okay");
                        String order_number = jsonResponse.getString("order_number");
                        String user = jsonResponse.getString("user");

                        // Now that we've got it all, we must render it to a text view with a little tick :)
                        // Pass it to the valid ticket activity
                        Intent intent = new Intent(LoadingActivity.this, ScannedItemActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("order_number", order_number);
                        LoadingActivity.this.startActivity(intent);

                    } else {
                        Intent intent = new Intent(LoadingActivity.this, NotValidActivity.class);
                        LoadingActivity.this.startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        SharedPreferences userDetails = getSharedPreferences("Login", MODE_PRIVATE);
        String username = userDetails.getString("username", "");

        CheckInRequest checkInRequest = new CheckInRequest(qrcode, username, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoadingActivity.this);
        queue.add(checkInRequest);
    }

}
