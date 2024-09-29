package com.example.actividadtriviaeje13;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        boolean esGanador = getIntent().getBooleanExtra("resultado", false);
        String nombre = getIntent().getStringExtra("nombreUsuario");

        Fragment fragment;
        if (esGanador) {
            fragment = FragmentoGanador.newInstance(nombre);
        } else {
            fragment = FragmentoPerdedor.newInstance(nombre);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
