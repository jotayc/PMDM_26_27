package com.example.pmdm;

import static com.example.pmdm.SecondActivity.INFO_ID;
import static com.example.pmdm.SecondActivity.RESULT_ID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Actividad Interfaz: resultado de otra actividad
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicarán los conceptos:
 *  1- Abrir una actividad esperando que devuelva un resultado
 *  2- El código de petición (request code)
 *  3- El código de resultado (result code)
 *  4- Recogida del resultado en onActivityResult
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: Declaración de objetos
    TextView txtVwMsg;
    Button btnMain;

    //Todo 2: Código de petición (request code): identifica a qué actividad se le pidió el resultado
    //Todo -> el número es indiferente, pero no debe repetirse para otros request code
    public static final int RQ_SECOND_ACT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo 3: Metodo para conectar la vista con la actividad.
        setContentView(R.layout.activity_main);

        //Todo 4: Inicialización de variables
        txtVwMsg = (TextView) findViewById(R.id.txtVw_main);
        btnMain = (Button) findViewById(R.id.btn_main);

        //Todo 5: El botón abre la segunda actividad
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Todo 6: La ida: intención explícita con un texto para la segunda actividad
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra(INFO_ID, "Hola desde MainActivity");

                //Todo 7: Llamamos a la variante del método que lanza la actividad e indica que
                //Todo -> se esperará un resultado.
                //Todo -> El segundo parámetro "Request Code" se encargará de identificar de qué
                //Todo    actividad se está recibiendo el mensaje.
                //Todo -> Es la forma clásica: Android Studio la marca como obsoleta. La actual,
                //Todo    registerForActivityResult(), está en el apartado 9.4 de los apuntes de la UD2
                startActivityForResult(i,RQ_SECOND_ACT);
            }
        });


    }

    //Todo 8: Sobrescribimos el método onActivityResult
    //Todo -> Android lo llama solo cuando la actividad que abrimos se cierra
    /**
     * Método que recibe información de una actividad lanzada anteriormente
     * @param requestCode Código que identifica qué actividad envía el mensaje.
     * @param resultCode Código que identifica si el mensaje que ha recibido es correcto o no.
     * @param data Contiene el mensaje.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Todo 9: Usamos RQ_SECOND_ACT para saber si el mensaje proviene de la segunda actividad
        if(requestCode == RQ_SECOND_ACT){
            //Todo 10: Usamos RESULT_OK para saber si el mensaje que llega es el correcto.
            //Todo -> si se vuelve con el botón Atrás llega RESULT_CANCELED y data vale null
            if(resultCode==RESULT_OK){
                //Todo 11: Extraemos la información del intent y la usamos
                String msg = data.getStringExtra(RESULT_ID);
                txtVwMsg.setText(msg);
            }

        }

    }
}
