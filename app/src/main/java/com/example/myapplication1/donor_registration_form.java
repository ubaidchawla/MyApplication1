package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class donor_registration_form extends AppCompatActivity {

    EditText name,f_name,age,ddmmyy,cnic,bloodgroup;
    Button btn;
    RadioGroup rg;
    RadioButton rfemale,rmale;

    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registration_form);

        name = (EditText) findViewById(R.id.txtname);
        f_name = (EditText) findViewById(R.id.txtfname);
        age = (EditText) findViewById(R.id.txtage);
        cnic = (EditText) findViewById(R.id.txtcnic);
        bloodgroup = (EditText) findViewById(R.id.txtbg);
        btn=(Button)findViewById(R.id.btn2);

        //initialize AwesomeValidation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        // add validation for name
        awesomeValidation.addValidation(this, R.id.txtname, RegexTemplate.NOT_EMPTY,R.string.namerror);
        awesomeValidation.addValidation(this, R.id.txtfname,RegexTemplate.NOT_EMPTY,R.string.f_namerror);
        awesomeValidation.addValidation(this, R.id.txtbg,RegexTemplate.NOT_EMPTY,R.string.bg);
        awesomeValidation.addValidation(this, R.id.cnic, RegexTemplate.NOT_EMPTY,R.string.invalid_cnic);
        awesomeValidation.addValidation(this, R.id.txtage,RegexTemplate.NOT_EMPTY,R.string.age);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    //on success
                    Toast.makeText(getApplicationContext(),"form submission is successful",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(donor_registration_form.this, location_page2.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Submission failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
