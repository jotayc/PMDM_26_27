package com.example.pmdm.controllers;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;
import com.example.pmdm.fragments.SettingsFragment;


public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //Todo 4. El fragmento de los TODO 2 y 3 se coloca dentro de esta actividad. Una transacción
        //Todo -> agrupa los cambios de fragmentos y commit() los aplica
        //Todo 5. replace() recibe el contenedor, que es la vista raíz de activity_setting.xml, y el
        //Todo -> fragmento que se muestra en él
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.setting_container, new SettingsFragment())
                .commit();

        //Todo 6. Esto es opcional: se activa la flecha de volver en la barra de app.
        //Todo -> getSupportActionBar() puede devolver null si el tema no tiene barra
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    //Todo 7. La flecha llega como cualquier opción del menú, con el id android.R.id.home.
    //Todo -> Al pulsarla se hace lo mismo que con el botón Atrás del móvil
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
