package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
        final Button bScanTickets = (Button) findViewById(R.id.bScanTickets);
        final Button bLogout = (Button) findViewById(R.id.bLogout);

        //Listen for scan tickets press
        bScanTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Scan Tickets Pressed");
                Intent intent = new Intent(UserAreaActivity.this, ScanTicketActivity.class);
                UserAreaActivity.this.startActivity(intent);
            }
        });

        //Listen for logout press
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Logout Pressed");
                finish();
            }
        });

    }
}
