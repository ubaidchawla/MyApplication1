package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.AbstractQueue;
import java.util.HashMap;
import java.util.Map;

public class verification_code extends AppCompatActivity {
    final EditText txtverf = (EditText)findViewById(R.id.editText2);
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        final EditText txtverf;
        Button btnverf;

        //Initializing the RequestQueue


        //Inilize confirm button fo dialog box and txt bar of dialog box
        btnverf = (Button)findViewById(R.id.button5);


        //On the click of the confirm button from alert dialog
        btnverf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                confirmOtp();
            }

        });


    }

    private void confirmOtp(){
        //Displaying a progressbar
        final ProgressDialog loading;
        loading = ProgressDialog.show(verification_code.this, "Authenticating", "Please wait while we check the entered code", false, false);

        //Getting the user entered otp from text bar
        final String otp = txtverf.getText().toString().trim();

        //Creating an string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, config.CONFIRM_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //if the server response is success
                        if (response.equalsIgnoreCase("success")) {
                            //dismissing the progressbar
                            loading.dismiss();

                            //Starting a new activity
                            startActivity(new Intent(verification_code.this, dashboard_activiy.class));
                        } else {
                            //Displaying a toast if the otp entered is wrong
                            Toast.makeText(verification_code.this, "Wrong OTP Please Try Again", Toast.LENGTH_LONG).show();
                            //Asking user to enter otp again

                            Intent intent = new Intent(verification_code.this, verification_code.class);
                            startActivity(intent);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(verification_code.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //Adding the parameters otp
                params.put(config.KEY_OTP, otp);
                return params;
            }
        };

        //Adding the request to the queue
        requestQueue.add(stringRequest);
    }
}


