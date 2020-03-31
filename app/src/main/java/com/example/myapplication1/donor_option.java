package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class donor_option extends AppCompatActivity {

    ImageView nb,nd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_option);

        nb=(ImageView)findViewById(R.id.nearestblood);
        nd=(ImageView)findViewById(R.id.notifydonor);

        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(donor_option.this, location_page2.class);
                startActivity(intent);
            }
        });

        nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(donor_option.this, donor_registration_form.class);
                startActivity(intent);
            }
        });
    }
}
