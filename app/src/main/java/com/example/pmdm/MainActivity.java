package com.example.pmdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

/**
 * Actividad Interfaz: Button
 * @author JC
 * @version 0.1
 *
 *  En esta rama se explicará los conceptos:
 *  1- Declaración e Inicialización de objetos TextView y Button
 *  2- Independencia del texto a través de archivo strings.xml
 *  3- Clases anónimas y uso de interfaces
 *  4- Conexión entre actividad y layout
 *  5- Ciclo de vida de las actividades
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Todo 2: Declaración de objetos
    private Button btn_show;
    private Button btn_hide;
    private TextView txt_view;

    //Todo 1: OnCreate como primera función para inicializar elementos de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo 3: Metodo para conectar la vista con la actividad.
        setContentView(R.layout.activity_main);


        //Todo 4: Inicialización de variables
        this.btn_show = (Button) findViewById(R.id.btn_show);
        this.btn_hide = (Button) findViewById(R.id.btnHide);
        this.txt_view = (TextView) findViewById(R.id.txt_view);

        //Todo 5. Dos formas de atender el clic de un botón (solo puede estar activa una):
        //Todo -> Forma 2 (activa): la actividad implementa View.OnClickListener y un único
        //Todo    onClick() atiende a los dos botones, distinguiéndolos por su id.
        this.btn_show.setOnClickListener(this);
        this.btn_hide.setOnClickListener(this);

        //Todo -> Forma 1: una clase anónima por botón.
        //Todo    Si la activas, sustituye a la forma 2, porque cada botón guarda un solo listener.
        // this.btn_show.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         btn_show.setText("Un saludo");
        //     }
        // });
        // this.btn_hide.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         btn_show.setText("Adios");
        //     }
        // });

        //Todo -> La pulsación larga usa una clase anónima.
        //Todo    Desde Java 8, las clases anónimas de un solo método se pueden sustituir por lambdas.

        this.btn_show.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txt_view.setText("Esto es una pulsación larga");
                return true;
            }
        });
    }

    //Todo 6. Los siguientes métodos forman parte del ciclo de vida de cualquier actividad
    //Todo    Se podría ver como un diagrama de estados.


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //Implementación del método onClick de la interfaz OnClickListener (forma 2)
    @Override
    public void onClick(View view) {
        Button btn = (Button) view;

        if (btn.getId() == R.id.btn_show) {
            this.btn_show.setText("Un saludo");
        } else if (btn.getId() == R.id.btnHide) {
            this.btn_show.setText("Adios");
        }
    }
}