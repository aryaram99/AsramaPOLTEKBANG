package com.example.asramapoltekbang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton klik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        klik = (ImageButton) findViewById(R.id.alpha);
        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this,Alpha.class);
                startActivity(intent);
            }
        });

        klik = (ImageButton) findViewById(R.id.bravo);
        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this,Bravo.class);
                startActivity(intent);
            }
        });

        klik = (ImageButton) findViewById(R.id.charlie);
        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this,Charlie.class);
                startActivity(intent);
            }
        });

        klik = (ImageButton) findViewById(R.id.delta);
        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this,Delta.class);
                startActivity(intent);
            }
        });

        klik = (ImageButton) findViewById(R.id.echo);
        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this,Echo.class);
                startActivity(intent);
            }
        });
    }
}
