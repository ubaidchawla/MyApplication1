package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class chose_lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_lab);

        RadioGroup rg=(RadioGroup) findViewById(R.id.rg1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
                switch (checkedid)
            {
                case R.id.agha:
                    Intent intent= new Intent(chose_lab.this, Aghakhanlab.class);
                    startActivity(intent);

                    case  R.id.dow:
                        Intent intent1= new Intent(chose_lab.this, daw_lab.class);
                        startActivity(intent1);

                case R.id.s:
                    Intent intent2= new Intent(chose_lab.this, shukatkhanamlab.class);
                    startActivity(intent2);

                case R.id.quetta:
                    Intent intent3= new Intent(chose_lab.this, quetta_lab.class);
                    startActivity(intent3);

                case R.id.fayaz:
                    Intent intent4= new Intent(chose_lab.this, fayazlab.class);
                    startActivity(intent4);
            }
            }
        });
            }
}
