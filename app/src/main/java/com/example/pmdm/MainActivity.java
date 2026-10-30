package com.example.pmdm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Actividad Menú simple
 * @author JC
 * @version 0.3
 *
 *  En esta rama se explicará cómo:
 *  1- Crear un menú simple e interactuar con los item que lo componen.
 *
 *  Consideraciones previas:
 *   1. Se debe crear una carpeta nueva en res/menu
 *   2. Dentro de esta, se crea un xml cuyo elemento raíz es <menu></menu>
 *   3. Importante el atributo app:showAsAction, cuyo fin es indicar cómo se debe mostrar cada item
 *      en la barra. Existen diferentes formas que podéis ver en la documentación oficial
 *      https://developer.android.com/guide/topics/resources/menu-resource?hl=es-419
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: El layout al que se le cambia el fondo y el color elegido, que empieza siendo blanco
    private ConstraintLayout constraintLayout;
    int selectedColor = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Todo 2: La vista raíz del layout también se obtiene por su id
        constraintLayout = (ConstraintLayout) findViewById(R.id.root_const_lay);

    }

    //Todo 3: Se sobrescribe el método onCreateOptionsMenu para indicar que la app tiene un menú propio.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Todo 4: El inflater construye las opciones a partir del XML y las añade al menú que
        //Todo -> recibe el método. Android se encarga de colocarlas en la barra
        getMenuInflater().inflate(R.menu.simple_menu,menu);

        return true;
    }

    //Todo 5: Se sobrescribe el método onOptionsItemSelected, al que Android llama cuando se pulsa
    //Todo -> una opción del menú, y que la recibe como parámetro
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Todo 6: Se compara el id de la opción pulsada con los id del XML
        int itemId = item.getItemId();

        //Todo 7: Pulsar un color solo lo guarda: el fondo todavía no cambia
        if (itemId == R.id.item_blue) {
            selectedColor = Color.BLUE;
            myToast("Azul seleccionado");
        } else if (itemId == R.id.item_green) {
            selectedColor = Color.GREEN;
            myToast("Verde seleccionado");
        } else if (itemId == R.id.item_red) {
            selectedColor = Color.RED;
            myToast("Rojo seleccionado");
        } else if (itemId == R.id.item_apply) {
            //Todo 8: Pulsar Aplicar usa el color guardado
            constraintLayout.setBackgroundColor(selectedColor);
        }

        //Todo 9: Devolver true indica que la opción ya está atendida
        return true;
    }

    public void myToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
