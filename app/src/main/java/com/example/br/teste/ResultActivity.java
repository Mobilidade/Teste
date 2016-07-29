package com.example.br.teste;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = (TextView) findViewById(R.id.textView2);






        double resultado = getIntent().getDoubleExtra("teste",0);

        result.setText(String.valueOf(resultado));

        //Toast.makeText(this, resultado+" ", Toast.LENGTH_LONG).show();

    }
}
