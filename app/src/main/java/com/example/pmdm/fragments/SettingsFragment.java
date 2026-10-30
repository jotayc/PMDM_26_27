package com.example.pmdm.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.pmdm.R;


//Todo 2. Se crea una clase que hereda de PreferenceFragmentCompat, cuya función es construir la
//Todo -> pantalla de preferencias a partir del XML. Un fragmento es una parte de una pantalla, con
//Todo -> su propio ciclo de vida; aquí solo hay uno, que ocupa la actividad entera
public class SettingsFragment extends PreferenceFragmentCompat {


    //Todo 3. Este es el único método obligatorio: se indica qué XML describe las preferencias
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}
