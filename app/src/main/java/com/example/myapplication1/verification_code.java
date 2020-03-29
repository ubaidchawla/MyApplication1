package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class verification_code extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        final String otp_generated = getIntent().getStringExtra("OTP");
        TextView textView = (TextView) findViewById(R.id.textView4);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String otp = editText.getText().toString();
        textView.setText(otp_generated);

    }

}


