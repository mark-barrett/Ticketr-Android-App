package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        final Button bMyTickets = (Button) findViewById(R.id.bMyTickets);
        final Button bScanTickets = (Button) findViewById(R.id.bScanTickets);
        final Button bMyEvent = (Button) findViewById(R.id.bMyEvent);
        final Button bLogout = (Button) findViewById(R.id.bLogout);

        //Listen for my tickets press
        bMyTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("My Tickets Pressed");

                // Get user details from shared preferences
                SharedPreferences userDetails = getSharedPreferences("Login", MODE_PRIVATE);
                String username = userDetails.getString("username", "");
                String password = userDetails.getString("password", "");

                // Now that we have the users information that they entered, we must make a request to the API.
                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonResponse = new JSONArray(response);

                            // Check to make sure that the JsonArray has models in it
                            if (jsonResponse.toString().contains("\"model\":\""+"ticketr.order"+"\"")) {

                                // Make an array list to store orders
                                ArrayList<Order> orders = new ArrayList<Order>();

                                // Loop through the JSONArray, if the name is fields, then copy that into the new array
                                for(int i=0; i<jsonResponse.length(); i++) {
                                    // Grab the field
                                    JSONObject field = new JSONObject(jsonResponse.getJSONObject(i).getString("fields"));

                                    // Create an order object
                                    Order order = new Order(field.getString("order_number"),
                                                            field.getInt("ticket"),
                                                            field.getInt("event"),
                                                            field.getInt("user"),
                                                            field.getString("order_code"),
                                                            field.getBoolean("used"),
                                                            field.getBoolean("for_sale"));

                                    // Add the order to the array list.
                                    orders.add(order);
                                }

                                Intent intent = new Intent(UserAreaActivity.this, MyTicketsActivity.class);
                                //intent.putExtra("username", username);
                                UserAreaActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserAreaActivity.this);
                                builder.setMessage("Unable to get tickets. Sorry :(")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                TicketRequest ticketRequest = new TicketRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserAreaActivity.this);
                queue.add(ticketRequest);

            }
        });

        //Listen for scan tickets press
        bScanTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Scan Tickets Pressed");
            }
        });

        //Listen for my events press
        bMyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("My Events Pressed");
            }
        });

        //Listen for logout press
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Logout Pressed");
            }
        });

    }
}
