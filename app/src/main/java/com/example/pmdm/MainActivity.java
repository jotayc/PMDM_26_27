package com.example.pmdm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

/**
 * Actividad: Menú de acción
 *
 * @author JC
 * @version 0.2
 * <p>
 * Explica el uso de:
 * <p>
 * 1- Menú de acción: la barra de opciones que sustituye a la barra de app mientras se actúa
 *    sobre un elemento
 *
 *  Documentación -> https://developer.android.com/develop/ui/views/components/menus?hl=es-419#CAB
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: Guarda el modo de acción activo. Vale null mientras no hay ninguno abierto
    private ActionMode mActionMode;

    private Button btn_floating;
    private Button btn_action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_floating = (Button) findViewById(R.id.btn_floating);
        btn_action = (Button) findViewById(R.id.btn_action);

        //Todo 2: El menú se abre con una pulsación larga, que tiene su propio listener
        btn_action.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                boolean atendida = false;
                //Todo 3: Solo se abre si no hay ya uno abierto. startSupportActionMode() recibe
                //Todo -> el objeto que responderá a lo que pase en el menú (TODO 4)
                if (mActionMode == null) {
                    mActionMode = startSupportActionMode(mActionCallback);
                    atendida = true;
                }

                return atendida;
            }
        });


    }


    //Todo 4: Clase anónima, como en los listener, pero esta vez la instancia se guarda en un
    //Todo -> atributo para que el código se lea mejor. Android llamará a sus cuatro métodos
    private ActionMode.Callback mActionCallback = new ActionMode.Callback() {
        //Todo 5: Se llama al abrirse: se infla el menú del XML y se pone el título de la barra
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.action_menu, menu);
            mode.setTitle("Action Menu");
            return true;
        }

        //Todo 6: Se llama justo después y cada vez que se refresca. Sirve para cambiar opciones
        //Todo -> sobre la marcha. Devuelve false porque aquí no se cambia nada
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        //Todo 7: Se llama al pulsar una opción, que llega como parámetro
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int itemId = item.getItemId();

            if (itemId == R.id.act_light_blue) {
                btn_action.setBackgroundColor(Color.CYAN);
            } else if (itemId == R.id.act_purple) {
                btn_action.setBackgroundColor(Color.MAGENTA);
            } else if (itemId == R.id.act_yellow) {
                btn_action.setBackgroundColor(Color.YELLOW);
            }

            //Todo 8: Hecha la acción, se cierra el menú y vuelve la barra de app
            mode.finish();
            return true;
        }

        //Todo 9: Se llama al cerrarse de cualquier forma: con finish(), con la flecha de la barra o
        //Todo -> con Atrás. Se pone a null para que la siguiente pulsación larga pueda abrirlo
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };
}
