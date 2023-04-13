package com.example.ricaricatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent primaschermata = getIntent();
        int numtel = primaschermata.getIntExtra("Telefono", 0);

        TextView title = (TextView) findViewById(R.id.txt_info);

        title.setText("Numero di Telefono: " + numtel);
    }
}