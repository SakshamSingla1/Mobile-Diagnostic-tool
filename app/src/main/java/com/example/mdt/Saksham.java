package com.example.mdt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Saksham extends AppCompatActivity {
    ImageView battery,calllog,camera,hardware,software,sensor,sound, display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery =findViewById(R.id.battery);
        calllog = findViewById(R.id.calllog);
        camera = findViewById(R.id.camera);
        hardware = findViewById(R.id.hardware);
        software = findViewById(R.id.software);
        sensor = findViewById(R.id.sensor);
        sound = findViewById(R.id.sound);
        display = findViewById(R.id.display);

        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Battery.class);
                startActivity(intent);
            }
        });

        calllog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Calllog.class);
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Camera.class);
                startActivity(intent);
            }
        });

        hardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Hardware.class);
                startActivity(intent);
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,System.class);
                startActivity(intent);
            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Sensor.class);
                startActivity(intent);
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,Sound.class);
                startActivity(intent);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saksham.this,DisplayInfo.class);
                startActivity(intent);
            }
        });



    }
}