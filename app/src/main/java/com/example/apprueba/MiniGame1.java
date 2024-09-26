package com.example.apprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MiniGame1 extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private List<String> textos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mini_game1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los botones
        button1 = findViewById(R.id.LN_1button1);
        button2 = findViewById(R.id.LN_2button2);
        button3 = findViewById(R.id.LN_3button3);
        button4 = findViewById(R.id.LN_4button4);
        button5 = findViewById(R.id.LN_5button5);
        button6 = findViewById(R.id.LN_6button6);

        // Obtener la lista de textos
        textos = obtenerListaDeTextos();

        // Asignar un texto inicial a cada botón
        asignarTextoBotones();

        // Agregar OnClickListener a cada botón
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTextoAleatorio(button6);
            }
        });
    }

    private void asignarTextoBotones() {
        button1.setText(textos.get(0));
        button2.setText(textos.get(1));
        button3.setText(textos.get(2));
        button4.setText(textos.get(3));
        button5.setText(textos.get(4));
        button6.setText(textos.get(5));
    }

    private void cambiarTextoAleatorio(Button button) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(textos.size());
        button.setText(textos.get(indiceAleatorio));
    }

    private List<String> obtenerListaDeTextos() {
        List<String> textos = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            textos.add(String.valueOf(c));
        }
        for (int i = 0; i <= 9; i++) {
            textos.add(String.valueOf(i));
        }

        // Mezclar la lista de textos
        Collections.shuffle(textos);

        return textos;
    }


}