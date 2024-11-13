package com.example.Theatre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theatre.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Замените 'activity_main' на имя вашего макета

        // Находим кнопки в макете
        Button vehiclesButton = findViewById(R.id.vehiclesButton);
        Button serviceTypeButton = findViewById(R.id.serviceTypeButton);
        Button partsButton = findViewById(R.id.partsButton);
        Button workButton = findViewById(R.id.workButton);
        Button invoiceButton = findViewById(R.id.invoiceButton);


        vehiclesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Actor.class);
                startActivity(intent);
            }
        });

        serviceTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Buy.class);
                startActivity(intent);
            }
        });

        partsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Post.class);
                startActivity(intent);
            }
        });

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.Theatre.Spec.class);
                startActivity(intent);
            }
        });

        invoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Theatre.class);
                startActivity(intent);
            }
        });
    }
}



