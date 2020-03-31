package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF2 extends AppCompatActivity {

    PDFView report2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        report2=(PDFView)findViewById(R.id.pdfreport2);

        report2.fromAsset("Lab 02.pdf").load();
    }
}
