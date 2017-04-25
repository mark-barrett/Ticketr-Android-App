package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ScannedItemActivity extends AppCompatActivity {

    String response_reason = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_item);

        Intent intent = getIntent();
        String qrcode = intent.getStringExtra("qrcode");

        final TextView tvOrderNumber = (TextView) findViewById(R.id.tvOrderNumber);
        final TextView tvUser = (TextView) findViewById(R.id.tvUser);

        final Button bScanAnother = (Button) findViewById(R.id.bScanAnother);

        //Listen for scan another press
        bScanAnother.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              System.out.println("Scan Another");
                                              Intent intent = new Intent(ScannedItemActivity.this, ScanTicketActivity.class);
                                              ScannedItemActivity.this.startActivity(intent);
                                          }
                                      });

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

                        tvOrderNumber.setText(order_number);
                        tvUser.setText("Hey "+user+", welcome to the event!");

                        // Now that we've got it all, we must render it to a text view with a little tick :)
                    } else {
                        Intent intent = new Intent(ScannedItemActivity.this, NotValidActivity.class);
                        ScannedItemActivity.this.startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        SharedPreferences userDetails = getSharedPreferences("Login", MODE_PRIVATE);
        String username = userDetails.getString("username", "");

        CheckInRequest checkInRequest = new CheckInRequest(qrcode, username, responseListener);
        RequestQueue queue = Volley.newRequestQueue(ScannedItemActivity.this);
        queue.add(checkInRequest);

    }

}
