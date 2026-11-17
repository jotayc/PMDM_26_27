package com.example.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pmdm.io.ConnectionTask;

import java.util.ArrayList;

/**
 * Actividad peticiones REST: en esta actividad se ven las bases de las peticiones REST desde una
 * aplicación Android. Se piden a PokeAPI (https://pokeapi.co) los nombres de 100 pokémon y se
 * enseñan en una lista.
 *
 * CONSIDERACIONES PREVIAS:
 *  1. Para simplificar se usa la vista ListView. En una aplicación real se recomienda
 *  RecyclerView (rama 2.5).
 *  2. La aplicación necesita permiso para usar internet: está en AndroidManifest.xml (TODO 1).
 *  3. La petición se hace con AsyncTask (rama 3.4), en la clase io/ConnectionTask.java. AsyncTask
 *  está obsoleta desde la API 30. Al compilar sale el aviso "Some input files use or override a
 *  deprecated API"; no es un error.
 *
 * @author José Carlos Alfaro
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> pokeList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        // TODO 6. La lista empieza vacía: el adaptador enseña lo que haya en pokeList.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokeList);
        listView.setAdapter(adapter);

        // TODO 7. Se lanza la petición (ver la clase io/ConnectionTask). Al crear la tarea se le
        //  pasa lo que necesita para enseñar el resultado: el contexto, la lista y el adaptador.
        //  A execute() se le pasa el tipo de petición y el endpoint (ver la clase HttpConnectPokemon).
        new ConnectionTask(this, pokeList, adapter).execute("GET", "/pokemon?limit=100");

    }

}
