package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.util.Config;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class login_page_activity extends AppCompatActivity {
    //Volley RequestQueue
    private RequestQueue requestQueue;
    //String variables to hold phone
    private String phone;
    EditText txtphn;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_activity);


        //Initializing Views
        txtphn=(EditText)findViewById(R.id.editText);
        login = (Button)findViewById(R.id.button);

        //Initializing the RequestQueue
        requestQueue = Volley.newRequestQueue(this);

        //Adding a listener to button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Displaying a progress dialog
                final ProgressDialog loading = ProgressDialog.show(login_page_activity.this, "Registering", "Please wait...", false, false);

                //Getting user data
                phone = txtphn.getText().toString().trim();
                //Again creating the string request
                StringRequest stringRequest = new StringRequest(Request.Method.POST,config.REGISTER_URL,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        try {
                            //Creating the json object from the response
                            JSONObject jsonResponse = new JSONObject(response);

                            //If it is success
                            if(jsonResponse.getString(config.TAGRESPONSE).equalsIgnoreCase("Success")){
                                //Asking user to confirm otp
                                Intent intent= new Intent(login_page_activity.this, verification_code.class);
                                startActivity(intent);

                            }
                            else
                            {
                                //If not successful user may already have registered
                                Toast.makeText(login_page_activity.this, " Phone number already registered", Toast.LENGTH_LONG).show();
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                loading.dismiss();
                                Toast.makeText(login_page_activity.this, error.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //Adding the parameters to the request
                        params.put(config.KEY_PHONE, phone);
                        return params;
                    }
                };

                //Adding request the the queue
                requestQueue.add(stringRequest);
            }
        });
    }


}


