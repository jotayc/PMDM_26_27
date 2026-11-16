package com.example.pmdm.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

// TODO 2. Clase que gestiona la conexión con un servicio externo (una API REST) a través de una URL
//  base, a la que se le añade el "endpoint" (el final de la URL) según la información que
//  necesitemos. Los parámetros de una petición GET van en la propia URL, detrás del carácter '?'.
//  Ejemplo: https://pokeapi.co/api/v2 + /pokemon?limit=100
public class HttpConnectPokemon {

    // TODO 3. Declaramos la URL base, que no cambia.
    private static final String URL_BASE = "https://pokeapi.co/api/v2";

    // TODO 4. Método para las peticiones GET, las que se usan para consultar información.
    //  Devuelve el texto de la respuesta, o null si algo ha ido mal.
    public static String getRequest(String endpoint) {
        HttpURLConnection connection = null;
        String content = null;
        try {
            // TODO 4.1 Se forma la URL completa y se abre la conexión. La cabecera "Accept" indica
            //  al servidor en qué formato queremos la respuesta: JSON.
            URL url = new URL(URL_BASE + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");

            // TODO 4.2 Si el servidor devuelve el código 200 (HttpURLConnection.HTTP_OK), ha
            //  devuelto correctamente la información solicitada.
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // TODO 4.3 Se lee la respuesta línea a línea y se junta en un solo String.
                StringBuilder response = new StringBuilder();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                content = response.toString();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // TODO 4.4 Pase lo que pase, se cierra la conexión.
            if (connection != null) connection.disconnect();
        }
        return content;
    }

    // TODO 5. Método para las peticiones POST, las que se usan para enviar información nueva al
    //  servidor. Aquí los datos no van en la URL sino en el cuerpo de la petición (parámetro
    //  'body', un texto en formato JSON). Devuelve el código de respuesta del servidor, o -1 si no
    //  se ha podido conectar.
    //  En este ejemplo no se llama: PokeAPI solo permite consultar, no admite POST.
    public static int postRequest(String endpoint, String body) {
        HttpURLConnection connection = null;
        int responseCode = -1;
        try {
            URL url = new URL(URL_BASE + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            // "Content-Type" indica el formato de lo que enviamos; "Accept", el de lo que esperamos.
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            // Indica que la petición lleva cuerpo.
            connection.setDoOutput(true);

            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            writer.print(body);
            writer.flush();
            writer.close();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.disconnect();
        }
        return responseCode;
    }

}
