package com.example.pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Segunda actividad: recibe el texto enviado desde MainActivity
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicarán los conceptos:
 *  1- Recuperación de la intención que ha abierto la actividad
 *  2- Lectura de los datos que vienen dentro de ella
 *  3- Cierre de una actividad con finish()
 *
 */
public class SecondActivity extends AppCompatActivity {

    //Todo 9: El nombre del dato se guarda en una constante, no en un texto suelto
    //Todo -> las dos actividades usan la misma: la que envía y la que recibe
    //Todo -> es public static final para poder importarla desde MainActivity
    public static final String INFO_ID = "INFO";

    //Todo 10: Declaración de objetos
    TextView txtVwSec;
    Button btnSec;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo 11: Esta actividad tiene su propio layout: activity_second.xml
        setContentView(R.layout.activity_second);

        //Todo 12: Inicialización de variables
        txtVwSec    = (TextView) findViewById(R.id.txtVw_scnd);
        btnSec      = (Button) findViewById(R.id.btn_fin_scnd);
        editText    = (EditText) findViewById(R.id.edTxt_scnd);


        //Todo 13: getIntent() devuelve la intención con la que se ha abierto esta actividad
        Intent i = getIntent();

        //Todo 14: Se saca el extra por su nombre. Si no venía ninguno, devuelve null
        String msg = i.getStringExtra(INFO_ID);
        txtVwSec.setText(msg);


        //Todo 15: finish() cierra esta actividad y vuelve a la anterior
        //Todo -> no devuelve ningún dato; eso se verá en la rama UD_2_4_ActivityForResult
        btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
