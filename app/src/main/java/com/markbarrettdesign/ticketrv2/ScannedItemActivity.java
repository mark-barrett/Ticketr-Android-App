package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class ScannedItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_item);

        Intent intent = getIntent();
        String qrcode = intent.getStringExtra("qrcode");

        // Now that we have the qrcode, we need to validate it and see if its okay.

    }

}
