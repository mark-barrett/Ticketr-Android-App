package com.markbarrettdesign.ticketrv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ScannedItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_item);

        ArrayList<Order> orders =  (ArrayList<Order>)getIntent().getSerializableExtra("orders");

        populateListView(orders);
    }
}
