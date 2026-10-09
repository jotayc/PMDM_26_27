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
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Actividad Interfaz: resultado de otra actividad con registerForActivityResult
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicarán los conceptos:
 *  1- El lanzador (ActivityResultLauncher) y su registro
 *  2- El contrato: qué se lanza y qué se recibe
 *  3- El callback que recoge el resultado
 *  4- Apertura de la actividad con launch()
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: Declaración de objetos
    TextView txtVwMsg;
    Button btnMain;

    //Todo 2: El lanzador: el objeto con el que se abrirá la segunda actividad esperando un resultado
    //Todo -> <Intent> indica qué se le entrega al lanzarlo: una intención
    //Todo -> se registra aquí, como atributo, porque tiene que estar registrado antes de que
    //Todo    la actividad se muestre. Registrarlo más tarde (por ejemplo, dentro del onClick)
    //Todo    cierra la aplicación con IllegalStateException
    //Todo -> ya no hace falta código de petición (request code): cada lanzador recibe solo
    //Todo    su propia respuesta
    private final ActivityResultLauncher<Intent> secondLauncher = registerForActivityResult(

            //Todo 3: Primer parámetro, el contrato: dice qué tipo de petición es
            //Todo -> StartActivityForResult: se abre una actividad con una intención y
            //Todo    devuelve un ActivityResult
            new ActivityResultContracts.StartActivityForResult(),

            //Todo 4: Segundo parámetro, el callback: el código que se ejecutará cuando llegue el resultado
            //Todo -> es una clase anónima, igual que el OnClickListener de un botón
            new ActivityResultCallback<ActivityResult>() {

                /**
                 * Método que recibe la respuesta de la actividad abierta con este lanzador
                 * @param result Contiene el código de resultado y la intención con el mensaje.
                 */
                @Override
                public void onActivityResult(ActivityResult result) {

                    //Todo 5: Usamos RESULT_OK para saber si el mensaje que llega es el correcto.
                    //Todo -> si se vuelve con el botón Atrás llega RESULT_CANCELED y getData() vale null,
                    //Todo    por eso se comprueban las dos cosas
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){

                        //Todo 6: Extraemos la información del intent y la usamos
                        String msg = result.getData().getStringExtra(RESULT_ID);
                        txtVwMsg.setText(msg);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo 7: Metodo para conectar la vista con la actividad.
        setContentView(R.layout.activity_main);

        //Todo 8: Inicialización de variables
        txtVwMsg = (TextView) findViewById(R.id.txtVw_main);
        btnMain = (Button) findViewById(R.id.btn_main);

        //Todo 9: El botón abre la segunda actividad
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Todo 10: La ida: intención explícita con un texto para la segunda actividad
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra(INFO_ID, "Hola desde MainActivity");

                //Todo 11: Se abre la actividad con el lanzador, no con startActivity()
                //Todo -> launch() recibe la intención; la respuesta llegará al callback del Todo 4
                //Todo    cuando la segunda actividad se cierre
                secondLauncher.launch(i);
            }
        });


    }
}
