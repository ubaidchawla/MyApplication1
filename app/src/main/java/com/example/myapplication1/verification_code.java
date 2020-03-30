package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class verification_code extends AppCompatActivity {

    String otp_generated = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        otp_generated = getIntent().getStringExtra("OTP");
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(otp_generated);

    }

    public void verify(View view)
    {
        String phone = getIntent().getStringExtra("PHONE");
        EditText editText = (EditText) findViewById(R.id.editText2);
        String otp = editText.getText().toString();


        SharedPreferences sp = getSharedPreferences("com.example.myapplication1" ,Context.MODE_PRIVATE);
        sp.edit().putString("PHONE", phone);

        if (otp.equals(otp_generated))
        {
            Toast.makeText(this, "verified", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(verification_code.this, dashboard_activiy.class);
            startActivity(intent);
        }
    }

}


