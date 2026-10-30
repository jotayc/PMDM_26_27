package com.example.pmdm;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

/**
 * Actividad: Toast, AlertDialog y Snackbar
 * @author JC
 * @version 0.2
 *
 * Explica el uso de:
 *
 * 1- Toast como aviso breve sin interacción con el usuario
 * 2- AlertDialog como ventana que interrumpe y espera una respuesta
 * 3- Snackbar como aviso breve que puede ofrecer una acción
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: Un botón por cada forma de avisar al usuario
    Button btn_toast;
    Button btn_alert;
    Button btn_snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Todo 2: Se conecta cada botón con su vista del layout
        btn_toast = (Button)   findViewById(R.id.btn_toast);
        btn_alert = (Button)   findViewById(R.id.btn_alert);
        btn_snack = (Button)   findViewById(R.id.btn_snack);


        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 3: El Toast se muestra con un método propio, que está más abajo
                myLongToast("Esto es un toast igual que el primero que vimos");
            }
        });

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 4: Solo hay que pedir el AlertDialog al método que lo crea y mostrarlo
                AlertDialog alertDialog = createAlertDialog("Mi titulo", "Esto es un mensaje de alerta");
                alertDialog.show();
            }
        });

        btn_snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 5: Se crea el Snackbar a partir de una vista de la pantalla, aquí el botón pulsado
                Snackbar snackbar = Snackbar.make(view,"Esto es un mensaje snackbar",Snackbar.LENGTH_LONG);

                //Todo 6: OPCIONAL. Un Snackbar puede llevar un botón. Es útil, por ejemplo, para
                //Todo -> darle al usuario la opción de deshacer la última acción realizada
                snackbar.setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myLongToast("Aquí desharíamos lo que sea que hayamos hecho");
                    }
                });

                //Todo 7: Sin show() no se ve nada, igual que en el Toast
                snackbar.show();
            }
        });


    }


    /**
     * Método que encapsula la acción Toast, evita tener que repetir código en los parámetros que
     * nunca cambian, como puede ser la duración, el contexto o que se olvide llamar al método show()
     * @param msg Mensaje a mostrar en el toast.
     */
    public void myLongToast(String msg){
        //Todo 8: Un Toast es un mensaje de duración determinada SIN interacción del usuario.
        //Todo -> Hay que tener en cuenta que puede que el usuario no lo lea
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Esto es un método que encapsula la creación de cuadros de diálogo simples
     * @param titulo Contiene el título del cuadro de diálogo
     * @param mensaje Contiene el mensaje dentro del cuadro de diálogo
     * @return Devuelve el objeto AlertDialog
     */
    public AlertDialog createAlertDialog(String titulo, String mensaje){
        //Todo 9: Se crea un 'builder' o constructor que ayuda a configurar el cuadro de diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //Todo 10: El builder recibe todas las configuraciones antes de crear el diálogo.
        //Todo -> En este ejemplo, el mensaje y el título
        builder.setMessage(mensaje)
                .setTitle(titulo);

        //Todo 11: Cada botón lleva su texto y el listener que se ejecuta al pulsarlo.
        //Todo -> Después de ejecutarlo, el diálogo se cierra solo
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Ha pulsado Sí", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Ha pulsado No", Toast.LENGTH_SHORT).show();
            }
        });

        //Todo 12: Con todo configurado, se crea el AlertDialog y se devuelve.
        //Todo -> Crearlo no lo muestra: de eso se encarga el show() del TODO 4
        return builder.create();
    }

}
