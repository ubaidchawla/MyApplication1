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
    }
public void onRadioButtonClicked(View v){

    RadioGroup rg;
      RadioButton r1,r2,r3,r4,r5;

      rg=(RadioGroup)findViewById(R.id.rg1);

      r1=(RadioButton)findViewById(R.id.agha);
      r2=(RadioButton)findViewById(R.id.dow);
      r3=(RadioButton)findViewById(R.id.s);
      r4=(RadioButton)findViewById(R.id.quetta);
      r5=(RadioButton)findViewById(R.id.fayaz);

      boolean checked=((RadioButton)v).isChecked();

      switch (v.getId())
      {
          case R.id.agha:
               if (checked)
                  {
                    Intent intent= new Intent(chose_lab.this, Aghakhanlab.class);
                    startActivity(intent);
                  }
              break;
           case R.id.dow:
                if (checked)
                   {
                     Intent intent= new Intent(chose_lab.this, daw_lab.class);
                     startActivity(intent);
                   }
              break;

           case R.id.s:
                if (checked)
                   {
                     Intent intent= new Intent(chose_lab.this, shukatkhanamlab.class);
                     startActivity(intent);
                   }
              break;
           case R.id.quetta:
                if(checked)
                   {
                     Intent intent= new Intent(chose_lab.this, quetta_lab.class);
                     startActivity(intent);
                   }
              break;

           case R.id.fayaz:
                if(checked)
                  {
                    Intent intent= new Intent(chose_lab.this, fayazlab.class);
                    startActivity(intent);
                  }
             break;

            default:
             Toast.makeText(getApplicationContext(),"please choose your laboratory",Toast.LENGTH_SHORT).show();
                  }
                  }
                  }