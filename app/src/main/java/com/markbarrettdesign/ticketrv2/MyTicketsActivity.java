package com.markbarrettdesign.ticketrv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MyTicketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tickets);

        System.out.println("In my tickets getting the intent");
        ArrayList<Order> orders =  (ArrayList<Order>)getIntent().getSerializableExtra("orders");

        populateListView(orders);
    }

    private void populateListView(ArrayList<Order> orders) {
        // Build the adapter
        ArrayAdapter<Order> adapter = new ArrayAdapter<Order>(
                this, // Context
                R.layout.ticket, // Layou to use
                orders); // Items to be displayed

        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }
}
