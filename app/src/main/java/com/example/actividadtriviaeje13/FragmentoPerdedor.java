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


public class FragmentoPerdedor extends Fragment {

    private static final String ARG_NOMBRE = "nombreUsuario";

    public static FragmentoPerdedor newInstance(String nombre) {
        FragmentoPerdedor fragment = new FragmentoPerdedor();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_perdedor, container, false);
        TextView tvPerdedor = view.findViewById(R.id.tvPerdedor);
        Button btnReintentar = view.findViewById(R.id.btnReintentar);
        String nombre = getArguments().getString(ARG_NOMBRE);
        tvPerdedor.setText("Bueno, te equivocaste " + nombre);

        btnReintentar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TriviaActivity.class);
            intent.putExtra("nombreUsuario", nombre);
            startActivity(intent);
        });

        return view;
    }
}
