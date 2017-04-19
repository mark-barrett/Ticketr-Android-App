package com.markbarrettdesign.ticketrv2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMessage);

        // Display user details
        String message = username + " welcome to the Ticketr user area";
        tvWelcomeMsg.setText(message);

        // Get each button
        final Button bMyTickets = (Button) findViewById(R.id.bMyTickets);
        final Button bScanTickets = (Button) findViewById(R.id.bScanTickets);
        final Button bMyEvents = (Button) findViewById(R.id.bMyEvents);
        final Button bLogout = (Button) findViewById(R.id.bLogout);

        //Listen for each button
        bMyTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
    }
}
