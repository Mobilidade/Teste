package com.example.br.teste;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=1;

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {


            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(this, " Ok!!!!-------!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, " Negado!!!!!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, MessageActivity.class);
                    startActivity(intent);
                    finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText altural =(EditText) findViewById(R.id.editText);
        final EditText pesol = (EditText) findViewById(R.id.editText2);


///////////////////////////////////////////////////////////////////////////////////////////////

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {


                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.

        }
//////////////////////////////////////////////////////////////////////////////////////////////////



        Button Calc = (Button) findViewById(R.id.button);
        Calc.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v ) {

                double altura = Double.parseDouble(altural.getText().toString());
                double peso = Double.parseDouble(pesol.getText().toString());
                double result = (peso / (altura * altura));

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("teste", result);
                startActivity(intent);
            }

        });




}


}