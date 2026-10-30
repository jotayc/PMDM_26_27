package com.example.pmdm.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;


/**
 * Actividad Preferencias: En esta actividad se estudiará la persistencia de datos simples como son
 * las configuraciones de usuario a través de la API propia de Android.
 *
 * @author JC
 * @version 0.2
 *
 *  Consideraciones previas:
 *
 *    1 - El diseño de la configuración debe estar en la carpeta res/xml
 *    2 - Se debe importar la biblioteca preference, que en este proyecto está añadida en
 *        app/build.gradle con la línea: implementation libs.preference
 *    3 - Consultar la guía oficial https://developer.android.com/guide/topics/ui/settings?hl=es-419
 *
 */
public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private Button   mPrefBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.txtView);
        mPrefBtn = (Button)  findViewById(R.id.prefBtn);

        mPrefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo 1. La pantalla de preferencias es una actividad más, con su clase y su layout
                //Todo -> (SettingActivity y activity_setting.xml), y se abre con una intención
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Todo 8. Se cargan aquí, y no en onCreate, porque onResume también se ejecuta al volver de la
        //Todo -> pantalla de preferencias. Así el texto se actualiza con lo que acaba de escribir
        //Todo -> el usuario. En tu aplicación, cárgalas en el método que necesites
        loadPreferences();
    }


    public void loadPreferences(){

        //Todo 9. Guardar no es trabajo nuestro: Android almacena lo que el usuario introduce en la
        //Todo -> pantalla de preferencias. Aquí solo hay que leerlo

        //Todo 10. PreferenceManager da acceso a las preferencias compartidas. Son las mismas para
        //Todo -> toda la aplicación: cualquier actividad que las pida leerá los mismos datos
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        //Todo 11. Se lee por la clave, la misma de android:key en el XML. El segundo parámetro es
        //Todo -> el valor que se devuelve si esa clave todavía no tiene ningún valor guardado
        String emailText = sharedPreferences.getString("emailPreference","Valor por defecto");
        txtView.setText(emailText);
    }
}
