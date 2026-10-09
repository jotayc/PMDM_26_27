package com.example.pmdm;

import android.app.Activity;
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
 * Segunda actividad: devuelve a MainActivity el texto que se escribe en ella
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicarán los conceptos:
 *  1- Preparación de una intención con los datos que se devuelven
 *  2- setResult: el código de resultado y la intención de vuelta
 *  3- Entrega del resultado al cerrar la actividad con finish()
 *
 */
public class SecondActivity extends AppCompatActivity {

    //Todo 12: Los nombres de los datos se guardan en constantes, no en textos sueltos
    //Todo -> INFO_ID es el dato que llega desde MainActivity; RESULT_ID, el que se le devuelve
    public static final String INFO_ID = "INFO";
    public static final String RESULT_ID = "result";

    //Todo 13: Declaración de objetos
    TextView txtVwSec;
    Button btnSec;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Todo 14: Inicialización de variables
        txtVwSec    = (TextView) findViewById(R.id.txtVw_scnd);
        btnSec      = (Button) findViewById(R.id.btn_fin_scnd);
        editText    = (EditText) findViewById(R.id.edTxt_scnd);


        //Todo 15: Se recupera la intención que ha abierto la actividad y se muestra el texto que trae
        Intent i = getIntent();

        String msg = i.getStringExtra(INFO_ID);
        txtVwSec.setText(msg);


        btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 16: Solo se devuelve un resultado si se ha escrito algo
                String msg = editText.getText().toString();
                if(!msg.isEmpty()){
                    //Todo 17: En este caso creamos un intent para que devuelva el mensaje.
                    //Todo -> Este se entregará cuando la instancia de la actividad que lo devuelve finalice.
                    Intent returnIntent = new Intent();

                    //Todo 18: Se añade el mensaje al intent.
                    returnIntent.putExtra(RESULT_ID,msg);

                    //Todo 19: Se llama al método que añade el intent al resultado.
                    //Todo -> En este caso admite un parámetro inicial "ResultCode" que podrá ser
                    //Todo    dos valores estáticos dentro de la clase Activity:
                    //Todo -> RESULT_OK en caso de que el resultado devuelto sea correcto
                    //Todo -> RESULT_CANCELED en caso de que el resultado devuelto sea incorrecto.
                    setResult(Activity.RESULT_OK,returnIntent);

                    //Todo 20: Finalizamos la actividad para devolver el resultado.
                    //Todo -> en ese momento se ejecuta el callback del lanzador en MainActivity
                    finish();
                }


            }
        });


    }
}
