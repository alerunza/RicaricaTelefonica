package com.example.ricaricatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent primaschermata = getIntent();

        String oper = primaschermata.getStringExtra("Operatore");
        String numtel = primaschermata.getStringExtra("Telefono");
        int ricarica = primaschermata.getIntExtra("Ricarica", 0);

        TextView operatore = (TextView) findViewById(R.id.txt_operatore);
        TextView title = (TextView) findViewById(R.id.txt_info);
        TextView saldo = (TextView) findViewById(R.id.txt_saldo);

        operatore.setText(oper);
        title.setText("Numero di Telefono: " + numtel);
        saldo.setText(("Saldo: " + ricarica + "€"));
    }

    public void backHome(View v){
        Intent primascher = new Intent(this, MainActivity.class);
        startActivity(primascher);
    }
}