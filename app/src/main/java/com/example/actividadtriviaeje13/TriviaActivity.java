package com.example.actividadtriviaeje13;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TriviaActivity extends AppCompatActivity {

    private TextView tvSaludo;
    private RadioGroup rgRespuestas;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        tvSaludo = findViewById(R.id.tvSaludo);
        rgRespuestas = findViewById(R.id.rgRespuestas);
        btnEnviar = findViewById(R.id.btnEnviar);

        String nombre = getIntent().getStringExtra("nombreUsuario");
        tvSaludo.setText("Hola " + nombre);

        btnEnviar.setOnClickListener(v -> {
            int selectedId = rgRespuestas.getCheckedRadioButtonId();
            if (selectedId == R.id.rbOpcion3) {
                Intent intent = new Intent(TriviaActivity.this, ResultActivity.class);
                intent.putExtra("resultado", true);
                intent.putExtra("nombreUsuario", nombre);
                startActivity(intent);
            } else {
                Intent intent = new Intent(TriviaActivity.this, ResultActivity.class);
                intent.putExtra("resultado", false);
                intent.putExtra("nombreUsuario", nombre);
                startActivity(intent);
            }
        });
    }
}
