package com.example.pmdm.Controllers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm.Adapters.RecyclerAdapter;

import com.example.pmdm.Models.Pelicula;
import com.example.pmdm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad que explica los componentes necesarios para el uso de listas con RecyclerView.
 *
 * Organización previa:
 *
 *    1.- Se debe tener en cuenta la organización del proyecto separado en paquetes que sigan el patrón MVC
 *
 * @author JC
 * @version 0.1
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    //Todo 1: Se declaran los tipos de datos RecyclerView, que engloba la lista, y RecyclerAdapter, que enlazará los datos
    //Todo -> con cada elemento de la lista. En este caso RecyclerAdapter es una clase que debemos implementar nosotros.
    RecyclerView recyclerView;
    RecyclerAdapter recAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Todo 9: Se inicializan los objetos recyclerView y recAdapter (ver los TODO 2 a 8), pasándole
        //Todo -> a este último la lista de películas (TODO 10)
        recyclerView = (RecyclerView) findViewById(R.id.recView);

        recAdapter = new RecyclerAdapter(getListMovie());

        //Todo 11: La clase LayoutManager se encarga de gestionar la disposición de los elementos
        //Todo -> de la lista dentro del RecyclerView. Existen diferentes opciones, como GridLayoutManager,
        //Todo    que los coloca en vista de rejilla. Para este caso se ha usado Linear, para una
        //Todo    disposición básica (un elemento debajo de otro).
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //Todo 12: Por último solo debemos añadir los elementos creados anteriormente a la vista
        //Todo -> padre (RecyclerView) con sus respectivos métodos.
        //Todo -> sin adaptador o sin LayoutManager la lista no muestra nada
        recyclerView.setAdapter(recAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    //Todo 10: Como no sabemos (todavía) recuperar datos desde una base de datos se ha creado un
    //Todo -> método auxiliar que emule la obtención de datos. Para ello se han importado diferentes
    //Todo    imágenes en la carpeta drawable y se han creado diferentes objetos de la clase Pelicula,
    //Todo    almacenándolos en un ArrayList que posteriormente será devuelto.
    public static List<Pelicula> getListMovie(){

        ArrayList<Pelicula> list = new ArrayList<Pelicula>();

        list.add(new Pelicula("Aquaman","Una vez se cansó de ser el mejor en juego de tronos, cogió un tridente y se fue a nadar con los peces",R.drawable.aqua));
        list.add(new Pelicula("Batman vs Superman","Un hombre disfrazado de murciélago se pelea con un hombre con la ropa interior roja por fuera",R.drawable.batvssup));
        list.add(new Pelicula("Justice League","Un hombre disfrazado, el de juego de tronos, un robot, una mujer con una cuerda y el hombre de la ropa interior se pelean con un bicho",R.drawable.justleague));
        list.add(new Pelicula("Superman: Hijo rojo","¿Y si la ropa interior la hubiera comprado en Rusia?",R.drawable.supred));
        list.add(new Pelicula("Wonder Woman","Una mujer superfuerte con un lazo, no quiere que nadie sepa que es superfuerte y que tiene un lazo",R.drawable.wonwom));
        list.add(new Pelicula("Thor","Un hombre rubio superfuerte se pelea con su hermano y se encuentra con una de las gemas del...oh wait!! que alguien despida al becario!!",R.drawable.infiltrado));

        return list;

    }


}