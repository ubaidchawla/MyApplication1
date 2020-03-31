package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF3 extends AppCompatActivity {

    PDFView report3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf3);

        report3=(PDFView)findViewById(R.id.pdfreport3);

        report3.fromAsset("Lab 03.pdf").load();
    }
}
