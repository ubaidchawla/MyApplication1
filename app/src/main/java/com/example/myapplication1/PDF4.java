package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF4 extends AppCompatActivity {

    PDFView report4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf4);

        report4=(PDFView)findViewById(R.id.pdfreport1);

        report4.fromAsset("Lab 04.pdf").load();
    }
}
