package com.example.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Actividad AsyncTask: en esta actividad se trabajan las tareas asíncronas con la API de
 * Android AsyncTask. El mismo contador de la rama de hilos (del 0 al 100, un punto por segundo),
 * hecho con una tarea asíncrona en lugar de un Thread y runOnUiThread().
 *
 * AsyncTask está obsoleta desde la API 30: los apuntes de la rama explican por qué y cómo se
 * hace hoy.
 *
 * @author JC
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnCancel;
    private TextView mTextView;

    // TODO 1. Declaramos un atributo del tipo de la clase que hereda de AsyncTask (TODO 4).
    private PublishTask mTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart    = (Button) findViewById(R.id.btn_calc);
        btnCancel   = (Button) findViewById(R.id.btn_cancel);
        mTextView   = (TextView) findViewById(R.id.textView);



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO 2. Cada instancia solo se puede ejecutar una vez, por ello tendremos que
                //  crear una nueva instancia si queremos ejecutarla más de una vez.
                mTask = new PublishTask();
                mTask.execute();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO 3. cancel(true) marca la tarea como cancelada e interrumpe el hilo secundario.
                //  Al terminar doInBackground() se llamará a onCancelled() en lugar de onPostExecute().
                mTask.cancel(true);

            }
        });
    }

    // TODO 4. Creo una clase que herede de la clase ABSTRACTA AsyncTask. Esta clase recibe tres
    //  tipos de datos según los parámetros que necesitemos para realizar nuestra tarea:
    //  1º Es el tipo de dato necesario para la tarea asíncrona, la que se realizará en el hilo secundario.
    //  2º Es el tipo de dato de los parámetros que actualizarán el progreso de la tarea en la interfaz.
    //  3º Es el tipo de dato del resultado que devuelve la tarea asíncrona una vez finalizada.
    //  Void (con mayúscula) indica que ese tipo no se usa.


    private class PublishTask extends AsyncTask<Void, Integer, Void>{

        // TODO 5. Este método se utiliza para realizar cualquier preparación de la vista antes de
        //  realizar la tarea asíncrona.
        //  SE EJECUTA EN EL HILO PRINCIPAL
        @Override
        protected void onPreExecute() {
            btnStart.setEnabled(false);
            btnCancel.setEnabled(true);
        }

        // TODO 6. Este método se utiliza para realizar la tarea asíncrona.
        //  El resultado que devuelve lo recibe después el método onPostExecute() como
        //  parámetro (en este ejemplo no devuelve nada, por eso es Void).
        //  SE EJECUTA EN EL HILO SECUNDARIO: aquí no se puede tocar la vista.
        @Override
        protected Void doInBackground(Void... voids) {

            for(int i=0; i<=100 && !isCancelled(); i++){
                try {
                    Thread.sleep(1000);
                    // TODO 7. Método que llama a onProgressUpdate() pasándole como parámetro el
                    //  dato necesario para actualizar la vista.
                    publishProgress(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        // TODO 8. Método que nos permite mostrar el progreso en la vista durante la ejecución de la
        //  tarea asíncrona, con información que le pasa el hilo secundario. Se ejecuta CADA VEZ
        //  que se llama al método publishProgress().
        //  SE EJECUTA EN EL HILO PRINCIPAL
        //  Integer... values quiere decir que el método puede recibir un número indeterminado de
        //  parámetros. Dentro se usa como un array: values[0] es el primero.
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("AT", "OnPublish"+values[0]);
            mTextView.setText(values[0] + "%");

        }

        // TODO 9. Método que se llama en el caso de que se cancele la tarea con cancel() (TODO 3).
        //  Si se llama a este método, NO SE LLAMARÁ AL MÉTODO onPostExecute().
        //  SE EJECUTA EN EL HILO PRINCIPAL.
        @Override
        protected void onCancelled(Void unused) {
            super.onCancelled();
            Toast.makeText(MainActivity.this,"Proceso cancelado", Toast.LENGTH_SHORT).show();
            btnStart.setEnabled(true);
            btnCancel.setEnabled(false);
        }

        // TODO 10. Método que nos permite realizar acciones cuando la tarea asíncrona haya finalizado.
        //  Este método recibirá por parámetro el valor devuelto por el método doInBackground().
        //  SE EJECUTA EN EL HILO PRINCIPAL
        @Override
        protected void onPostExecute(Void unused) {
            btnStart.setEnabled(true);
            btnCancel.setEnabled(false);
        }
    }



}