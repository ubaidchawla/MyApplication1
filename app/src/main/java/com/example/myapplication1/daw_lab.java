package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;

public class daw_lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daw_lab);

        ScrollView ss=(ScrollView)findViewById(R.id.sv);
        Button btn=(Button)findViewById(R.id.button2);
        CheckBox c1,c2,c3,c4,c5,c6,c7;
        c1=(CheckBox)findViewById(R.id.checkbox1);
        c2=(CheckBox)findViewById(R.id.checkbox2);
        c3=(CheckBox)findViewById(R.id.checkbox3);
        c4=(CheckBox)findViewById(R.id.checkbox4);
        c5=(CheckBox)findViewById(R.id.checkbox5);
        c6=(CheckBox)findViewById(R.id.checkbox6);
        c7=(CheckBox)findViewById(R.id.checkbox7);

        c1.isChecked();
        c2.isChecked();
        c3.isChecked();
        c4.isChecked();
        c5.isChecked();
        c6.isChecked();
        c7.isChecked();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4= new Intent(daw_lab.this, registration_form.class);
                startActivity(intent4);
            }
        });
    }
}
