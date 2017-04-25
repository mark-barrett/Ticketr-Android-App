package com.markbarrettdesign.ticketrv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotValidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_valid);

        final Button bScanAnother = (Button) findViewById(R.id.bScanAnother);

        //Listen for scan another press
        bScanAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Scan Another");
                Intent intent = new Intent(NotValidActivity.this, ScanTicketActivity.class);
                NotValidActivity.this.startActivity(intent);
            }
        });
    }
}
