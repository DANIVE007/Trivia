package com.example.actividadtriviaeje13;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentoGanador extends Fragment {

    private static final String ARG_NOMBRE = "nombreUsuario";

    public static FragmentoGanador newInstance(String nombre) {
        FragmentoGanador fragment = new FragmentoGanador();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_ganador, container, false);

        TextView tvGanador = view.findViewById(R.id.tvGanador);
        Button btnReintentar = view.findViewById(R.id.btnReintentar);

        String nombre = getArguments().getString(ARG_NOMBRE);
        tvGanador.setText("¡Genial " + nombre + "! Ganaste!!!");

        btnReintentar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
