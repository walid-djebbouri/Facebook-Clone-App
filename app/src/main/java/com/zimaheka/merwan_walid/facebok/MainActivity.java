package com.zimaheka.merwan_walid.facebok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void envoyer (View view){

        final EditText em = (EditText)findViewById(R.id.editText3);
        final EditText ps = (EditText)findViewById(R.id.editText4);

        final String email = em.getText().toString().trim();
        final String passWord = ps.getText().toString().trim();

        Response.Listener<String>  stringListener = new Response.Listener<String>(){


            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success){

                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);




                    }
                    else {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();


                }
            }
        } ;


        connexion cnx = new connexion(email , passWord , stringListener ) ;
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(cnx);


    }




    }





