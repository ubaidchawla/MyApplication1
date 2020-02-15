package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class dashboard_activiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activiy);

        ImageView img,img2,img3,img4;

        img=(ImageView)findViewById(R.id.testblood);
        img2=(ImageView)findViewById(R.id.donateblood);
        img3=(ImageView)findViewById(R.id.video);
        img4=(ImageView)findViewById(R.id.myprofile);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard_activiy.this, chose_lab.class);
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard_activiy.this, donor_option.class);
                startActivity(intent);
            }
        });
       img3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });
    img4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(dashboard_activiy.this, user_profile.class);
            startActivity(intent);
        }
    });
    }
}
