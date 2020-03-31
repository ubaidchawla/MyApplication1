package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class registration_form extends AppCompatActivity  {
    //initialize variable
    EditText name,f_name,age,ddmmyy,cnic,price;
    Button btn;
    RadioGroup rg;
    RadioButton rfemale,rmale;

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        name = (EditText) findViewById(R.id.name);
        f_name = (EditText) findViewById(R.id.fname);
        age = (EditText) findViewById(R.id.age);
        ddmmyy = (EditText) findViewById(R.id.ddmmyy);
        cnic = (EditText) findViewById(R.id.cnic);
        price = (EditText) findViewById(R.id.price);
        btn=(Button)findViewById(R.id.btn);

        //initialize AwesomeValidation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        // add validation for name
        awesomeValidation.addValidation(this, R.id.name,RegexTemplate.NOT_EMPTY,R.string.namerror);
        awesomeValidation.addValidation(this, R.id.fname,RegexTemplate.NOT_EMPTY,R.string.f_namerror);
        awesomeValidation.addValidation(this, R.id.ddmmyy,RegexTemplate.NOT_EMPTY,R.string.DOB);
        awesomeValidation.addValidation(this, R.id.cnic, RegexTemplate.NOT_EMPTY,R.string.invalid_cnic);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //check validation
                if (awesomeValidation.validate()){
                    //on success
                    Toast.makeText(getApplicationContext(),"form submission is successful",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(registration_form.this, MapsActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Submission failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}





