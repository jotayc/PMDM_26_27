package com.example.pmdm;

import static com.example.pmdm.SecondActivity.INFO_ID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Actividad Interfaz: Intent
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicarán los conceptos:
 *  1- Varias actividades en una misma aplicación
 *  2- Intenciones explícitas para abrir otra actividad
 *  3- Envío de datos entre actividades con putExtra y getStringExtra
 *  4- La constante que da nombre al dato enviado
 *  5- Lectura del texto escrito en un EditText
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 2: Declaración de objetos
    EditText edTxtMain;
    Button btnMain;


    //Todo 1: OnCreate como primera función para inicializar elementos de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo 3: Metodo para conectar la vista con la actividad.
        setContentView(R.layout.activity_main);

        //Todo 4: Inicialización de variables
        edTxtMain = (EditText) findViewById(R.id.edtxt_main);
        btnMain = (Button) findViewById(R.id.btn_main);

        //Todo 5: El botón es quien lanza el cambio de pantalla, con una clase anónima
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Todo 6: Intención explícita: se dice exactamente qué actividad se quiere abrir
                //Todo -> el primer parámetro es el contexto; MainActivity.this porque estamos
                //Todo    dentro de una clase anónima y this se refiere al listener
                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //Todo 7: El texto escrito viaja dentro de la intención como un "extra"
                //Todo -> cada extra es un par nombre-valor; el nombre es la constante INFO_ID
                //Todo -> getText() devuelve un Editable, no un String: hay que convertirlo
                String msg = edTxtMain.getText().toString();
                if(!msg.isEmpty())
                    i.putExtra(INFO_ID, msg);

                //Todo 8: Se le pide a Android que abra la actividad descrita en la intención
                startActivity(i);
            }
        });


    }
}
