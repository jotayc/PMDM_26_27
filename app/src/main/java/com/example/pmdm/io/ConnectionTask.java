package com.example.pmdm.io;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

// TODO 8. Esperar la respuesta del servidor puede tardar, así que la petición se tiene que hacer
//  en un hilo secundario. Si se hace en el principal, Android no lo permite: lanza
//  NetworkOnMainThreadException. En este proyecto la recoge el catch de getRequest(), así que
//  la aplicación no se cierra, pero no llega ninguna respuesta.
//  Tipos: <String, Void, String> → recibe Strings (tipo de petición y endpoint), no publica
//  progreso y devuelve un String (la respuesta del servidor).
public class ConnectionTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "ConnectionTask";

    // TODO 9. Al ser una clase aparte, no puede usar los atributos de MainActivity: recibe en el
    //  constructor lo que necesita. El contexto, para los Toast; la lista y su adaptador, para
    //  enseñar los nombres.
    private final Context context;
    private final ArrayList<String> pokeList;
    private final ArrayAdapter<String> adapter;

    public ConnectionTask(Context context, ArrayList<String> pokeList, ArrayAdapter<String> adapter) {
        this.context = context;
        this.pokeList = pokeList;
        this.adapter = adapter;
    }

    // TODO 10. En el hilo secundario: se hace la petición según su tipo.
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

    // TODO 11. En el hilo principal, con la respuesta ya recibida: aquí sí se puede tocar la
    //  vista.
    @Override
    protected void onPostExecute(String response) {
        if (response == null) {
            Toast.makeText(context, "Problema al cargar los datos", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(TAG, "DATOS: " + response);
        try {
            // TODO 12. La respuesta es un texto en formato JSON. Para leerlo usamos las clases
            //  que nos proporciona Android (JSONObject y JSONArray). Antes hay que consultar
            //  la documentación de la API para conocer el formato de la respuesta:
            //  {"count": ..., "next": ..., "previous": ..., "results": [{"name": ..., "url": ...}, ...]}
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                String name = jsonArray.getJSONObject(i).getString("name");
                pokeList.add(name);
            }
            // TODO 13. Una vez tenemos los datos en nuestra colección, debemos avisar al
            //  adaptador de que la información ha cambiado.
            adapter.notifyDataSetChanged();
            Log.d(TAG, "Array: " + pokeList.toString());
        } catch (JSONException e) {
            // TODO 14. Si la respuesta no tiene el formato esperado, se avisa.
            Log.e(TAG, "Respuesta con un formato inesperado", e);
            Toast.makeText(context, "Los datos recibidos no son válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
