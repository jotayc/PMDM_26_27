package com.example.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pmdm.io.HttpConnectPokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
 *  3. La petición se hace con AsyncTask (rama 3.4), que está obsoleta desde la API 30. Al
 *  compilar sale el aviso "uses or overrides a deprecated API"; no es un error.
 *
 * @author José Carlos Alfaro
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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

        // TODO 7. Se lanza la petición: el primer parámetro es el tipo de petición y el segundo,
        //  el endpoint (ver la clase HttpConnectPokemon).
        new ConnectionTask().execute("GET", "/pokemon?limit=100");

    }

    // TODO 8. Esperar la respuesta del servidor puede tardar, así que la petición se tiene que hacer
    //  en un hilo secundario. Si se hace en el principal, Android no lo permite y la aplicación
    //  se cierra con NetworkOnMainThreadException.
    //  Tipos: <String, Void, String> → recibe Strings (tipo de petición y endpoint), no publica
    //  progreso y devuelve un String (la respuesta del servidor).
    private class ConnectionTask extends AsyncTask<String, Void, String> {

        // TODO 9. En el hilo secundario: se hace la petición según su tipo.
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            switch (params[0]) {
                case "GET":
                    result = HttpConnectPokemon.getRequest(params[1]);
                    break;
                case "POST":
                    result = Integer.toString(HttpConnectPokemon.postRequest(params[1], params[2]));
                    break;
            }
            return result;
        }

        // TODO 10. En el hilo principal, con la respuesta ya recibida: aquí sí se puede tocar la
        //  vista.
        @Override
        protected void onPostExecute(String response) {
            if (response == null) {
                Toast.makeText(MainActivity.this, "Problema al cargar los datos", Toast.LENGTH_SHORT).show();
                return;
            }
            Log.d(TAG, "DATOS: " + response);
            try {
                // TODO 11. La respuesta es un texto en formato JSON. Para leerlo usamos las clases
                //  que nos proporciona Android (JSONObject y JSONArray). Antes hay que consultar
                //  la documentación de la API para conocer el formato de la respuesta:
                //  {"count": ..., "next": ..., "previous": ..., "results": [{"name": ..., "url": ...}, ...]}
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++) {
                    String name = jsonArray.getJSONObject(i).getString("name");
                    pokeList.add(name);
                }
                // TODO 12. Una vez tenemos los datos en nuestra colección, debemos avisar al
                //  adaptador de que la información ha cambiado.
                adapter.notifyDataSetChanged();
                Log.d(TAG, "Array: " + pokeList.toString());
            } catch (JSONException e) {
                // TODO 13. Si la respuesta no tiene el formato esperado, se avisa.
                Log.e(TAG, "Respuesta con un formato inesperado", e);
                Toast.makeText(MainActivity.this, "Los datos recibidos no son válidos", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
