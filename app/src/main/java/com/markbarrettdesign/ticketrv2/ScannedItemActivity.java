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
        String user = intent.getStringExtra("user");
        String order_number = intent.getStringExtra("order_number");

        final TextView tvOrderNumber = (TextView) findViewById(R.id.tvOrderNumber);
        final TextView tvUser = (TextView) findViewById(R.id.tvUser);

        tvUser.setText("Hey "+user+", Welcome to the Event!");
        tvOrderNumber.setText("Order #: "+order_number);

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

    }

}
