package com.example.ricaricatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String operatore = "";
    int ricarica = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ricaricaTel(View v){
        EditText num = (EditText) findViewById(R.id.editTextPhone);

        Log.e("MainActivity", num.getText().toString());
        if(num.getText().toString().matches("")){
            Toast.makeText(this, "Immetti il tuo Numero di Telefono", Toast.LENGTH_SHORT).show();
            return;
        }

        if(num.getText().toString().length() < 9 || num.getText().toString().length() > 9){
            Toast.makeText(this, "Numero di Telefono troppo corto o lungo", Toast.LENGTH_SHORT).show();
            return;
        }

        if((ricarica != 0) && (!operatore.matches("")) && (num.getText().toString().length() == 9)){
            Intent postRicarica = new Intent(this, MainActivity2.class);
            postRicarica.putExtra("Operatore", operatore);
            postRicarica.putExtra("Ricarica", ricarica);
            postRicarica.putExtra("Telefono", num.getText().toString());
            startActivity(postRicarica);
        }
    }

    public void checkOperatore(View v){
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.rB1:
                if(checked){
                    operatore = "Wind3";
                    Log.e("MainActivity", operatore);
                }
                break;
            case R.id.rB2:
                if(checked){
                    operatore = "TIM";
                    Log.e("MainActivity", operatore);
                }
                break;
            case R.id.rB3:
                if(checked){
                    operatore = "Vodafone";
                    Log.e("MainActivity", operatore);
                }
                break;
        }

        //notifica che appare in basso
        Toast.makeText(getApplicationContext(), operatore, Toast.LENGTH_SHORT).show();
    }

    public void checkRicarica(View v){
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.rBr1:
                if(checked){
                    ricarica += 5;
                }
                break;
            case R.id.rBr2:
                if(checked){
                    ricarica += 10;
                }
                break;
            case R.id.rBr3:
                if(checked){
                    ricarica += 20;
                }
                break;
        }

        //notifica che appare in basso
        Toast.makeText(getApplicationContext(), Integer.toString(ricarica), Toast.LENGTH_SHORT).show();
    }
}