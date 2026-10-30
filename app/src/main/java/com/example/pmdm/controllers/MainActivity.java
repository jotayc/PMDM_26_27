package com.example.pmdm.controllers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;
import com.example.pmdm.Resources.DBAccess;

/**
 * Actividad SQLite En esta actividad se explica una versión simplificada de cómo funcionan las bases
 * de datos SQLite en Android.
 * @author JC
 * @version 0.3
 *
 *  CONSIDERACIONES PREVIAS:
 *   1. El diseño de las tablas no es correcto, puesto que faltaría una clave primaria en la tabla 'ciudades'
 *   2. El funcionamiento de este ejemplo no está completo (no se muestra toda la información de las tablas de la BBDD)
 *   3. Por simplificación en la explicación, este ejemplo no sigue el patrón MVC (Habría que crearse la clase 'City' o 'Ciudad')
 *
 */
public class MainActivity extends AppCompatActivity {

    EditText mEtPobl;
    EditText mEtCity;
    EditText mEtSurf;
    TextView mTvView;
    Button mButton;
    Button mBtnMostrar;
    DBAccess mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton         = (Button)   findViewById(R.id.btnInsert);
        mBtnMostrar     = (Button)   findViewById(R.id.btnShow);
        mEtPobl = (EditText) findViewById(R.id.etPoblation);
        mEtSurf = (EditText) findViewById(R.id.etSurface);
        mEtCity = (EditText) findViewById(R.id.idCity);

        mTvView         = (TextView) findViewById(R.id.txtVw);

        //Todo 22. Se crea el objeto que da acceso a la base de datos. Al pedir la versión se abre:
        //Todo -> es ahí cuando Android ejecuta onCreate u onUpgrade, si hace falta
        mDB = new DBAccess(this);
        mDB.getVersionDB();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city = mEtCity.getText().toString();
                String textoPobl = mEtPobl.getText().toString();
                String textoSurf = mEtSurf.getText().toString();

                //Todo 23. Convertir un texto vacío en número cierra la aplicación: primero se comprueba
                if(city.isEmpty() || textoPobl.isEmpty() || textoSurf.isEmpty()){
                    myToast("Rellena los tres campos");
                    return;
                }

                int pobl    = Integer.parseInt(textoPobl);
                float surf   = Float.parseFloat(textoSurf);

                //Todo 24. insert devuelve -1 si la fila no se ha podido guardar
                if(mDB.insert(city, pobl, surf) != -1){
                    myToast("Ciudad insertada correctamente");
                }else{
                    myToast("Error! Ciudad no insertada. Comprueba Logcat");
                }
            }
        });

        mBtnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 25. getFirstCity devuelve null si la tabla está vacía
                String ciudad = mDB.getFirstCity();

                if(ciudad != null){
                    mTvView.setText(ciudad);
                }else{
                    myToast("Problema al recuperar la ciudad");
                }

            }
        });

    }

    public void myToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
