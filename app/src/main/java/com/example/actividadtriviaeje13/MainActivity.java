package com.example.actividadtriviaeje13;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnComenzar = findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            if (!nombre.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, TriviaActivity.class);
                intent.putExtra("nombreUsuario", nombre);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
