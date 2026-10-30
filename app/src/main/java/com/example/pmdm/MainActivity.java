package com.example.pmdm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad: Menús contextuales
 * @author JC
 * @version 0.2
 *
 * Explica el uso de:
 *
 * 1- Menú contextual flotante
 *
 */
public class MainActivity extends AppCompatActivity {


    private Button btn_floating;
    private Button btn_action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_floating = (Button)   findViewById(R.id.btn_floating);
        btn_action = (Button)   findViewById(R.id.btn_action);

        //Todo 1: Se registra la vista donde queremos que aparezca el menú contextual.
        //Todo -> A partir de aquí, una pulsación larga sobre ella abre el menú
        registerForContextMenu(btn_floating);
    }

    //Todo 2: Se sobrescribe el método onCreateContextMenu, al que Android llama cuando hay que
    //Todo -> crear el menú. Recibe el menú vacío y la vista que se ha pulsado
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Todo 3: Se crean las opciones a partir del XML y se le pone un título al menú
        getMenuInflater().inflate(R.menu.floating_menu,menu);
        menu.setHeaderTitle("Menu flotante");
    }

    //Todo 4: Se sobrescribe el método onContextItemSelected para responder a las opciones del menú
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.fl_blue) {
            btn_floating.setBackgroundColor(Color.BLUE);
        } else if (itemId == R.id.fl_green) {
            btn_floating.setBackgroundColor(Color.GREEN);
        } else if (itemId == R.id.fl_red) {
            btn_floating.setBackgroundColor(Color.RED);
        }

        //Todo 5: Devolver true indica que la opción ya está atendida
        return true;
    }

    //Todo 6: Se llama cuando el menú se cierra, tanto si se ha elegido una opción como si no
    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        myToast("Menu cerrado");
    }

    /**
     * Método que encapsula la acción Toast, evita tener que repetir código en los parámetros que
     * nunca cambian, como puede ser la duración, el contexto o que se olvide llamar al método show()
     * @param msg Mensaje a mostrar en el toast.
     */
    public void myToast(String msg){

        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}
