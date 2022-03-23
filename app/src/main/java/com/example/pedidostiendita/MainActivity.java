package com.example.pedidostiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText direc;
    private EditText  pedi;
    private ImageButton ini;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String name;
    String direccion;
    String pedido;

    String HttpUrl = "https://bluer-designators.000webhostapp.com/codigo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.name);
        direc = (EditText) findViewById(R.id.direccion);
        pedi = (EditText) findViewById(R.id.pedido);
        ini = (ImageButton) findViewById(R.id.pedir);

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        progressDialog = new ProgressDialog(MainActivity.this);


        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                    progressDialog.show();


                    GetValueFromEditText();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String ServerResponse) {

                                    progressDialog.dismiss();


                                    Toast.makeText(MainActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                                }
                            },
                            new Response.ErrorListener() {
                                private VolleyError error;

                                @Override
                                public void onErrorResponse(VolleyError volleyError) {

                                    progressDialog.dismiss();

                                    Toast.makeText(MainActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {


                            Map<String, String> params = new HashMap<String, String>();

                            params.put("name", name);
                            params.put("direccion", direccion);
                            params.put("pedido", pedido);

                            return params;
                        }



                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);

                


            }
            });
        }
    public void GetValueFromEditText(){

        name = nombre.getText().toString().trim();
        direccion = direc.getText().toString().trim();
        pedido = pedi.getText().toString().trim();

    }
}