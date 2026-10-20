package com.example.pmdm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pmdm.Models.Pelicula;
import com.example.pmdm.R;

import java.util.List;

//Todo 4: Se crea la clase heredando de Adapter, que admite un tipo ViewHolder necesario para
//Todo -> contener los elementos de la vista (MIRAR ANTES EL TODO 2)
//Todo -> el adaptador recibe en su constructor la lista de datos y la guarda
public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {
    List<Pelicula> listMovies;

    public PeliculaAdapter(List<Pelicula> listMovies) {
        this.listMovies = listMovies;
    }

    //Todo 5: Este método se encarga de crear la estructura de componentes de cada celda de la
    //Todo -> lista a partir del layout creado (en este caso custom_item_list.xml)
    //Todo -> solo se llama cuando hace falta una celda y no hay ninguna libre para reciclar
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Todo 6: El LayoutInflater podría verse como un elemento que se encarga de coger la
        //Todo -> vista de la celda y anidarla en la estructura jerárquica del padre (parent). En este
        //Todo    caso responde a la pregunta: «Esta celda, ¿en qué elemento gráfico de tipo lista va
        //Todo    a mostrarse?». Una vez hecho eso se pasa al ViewHolder para que enlace los elementos
        //Todo    del layout con los tipos de datos de cada clase, para que puedan ser manipulados en
        //Todo    tiempo de ejecución
        //Todo -> el false indica que la celda no se añade todavía a la lista: lo hará el RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    //Todo 7: Este método se encarga de enlazar la información con cada celda. Es llamado cada
    //Todo -> vez que una celda va a mostrar un elemento, tanto si es nueva como si es reciclada,
    //Todo    y lo único que hay que hacer es extraer la información del elemento en la lista y
    //Todo    asignársela a cada elemento gráfico de la celda.
    //Todo -> hay que rellenar todas las vistas: una celda reciclada trae los datos de antes
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = listMovies.get(position);
        holder.txtViewDesc.setText(pelicula.getDescripcion());
        holder.txtViewTitle.setText(pelicula.getTitulo());
        holder.imgPelicula.setImageResource(pelicula.getImagenId());
    }

    //Todo 8: Devuelve cuántos elementos tiene la lista. Si devolviera 0, la lista saldría vacía
    @Override
    public int getItemCount() {
        return listMovies.size();
    }


    //Todo 2: Primero se crea la clase que hereda de ViewHolder. Esta clase tiene como finalidad
    //Todo -> recrear los elementos de la vista del layout de cada elemento de la lista acorde al
    //Todo    modelo de datos creado (en este caso la clase Pelicula)
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPelicula;
        TextView txtViewTitle;
        TextView  txtViewDesc;

        //Todo 3: El constructor recibe como parámetro un tipo vista (itemView) que contiene la celda
        //Todo -> ya creada a partir del layout correspondiente
        //Todo -> las vistas se buscan dentro de itemView, una sola vez: después se reutilizan
        //Todo -> funciona como un acceso directo: en onBindViewHolder se usan sin volver a buscarlas
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPelicula  = (ImageView) itemView.findViewById(R.id.img_item);
            txtViewTitle = (TextView)  itemView.findViewById(R.id.txt_item_tittle);
            txtViewDesc  = (TextView)  itemView.findViewById(R.id.txt_item_desc);


        }
    }
}
