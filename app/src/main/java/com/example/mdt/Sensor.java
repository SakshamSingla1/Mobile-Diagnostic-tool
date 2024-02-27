package com.example.mdt;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Sensor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        Button accelerometerButton = findViewById(R.id.accelerometerButton);

        accelerometerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, Accelerometer.class);
                startActivity(intent);
            }
        });
        Button gyroscopeButton = findViewById(R.id.gyroscopeButton);

        gyroscopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, GyroscopeActivity.class);
                startActivity(intent);
            }
        });
        Button rotationButton = findViewById(R.id.rotationVectorButton);

        rotationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, RotationSensorActivity.class);
                startActivity(intent);
            }
        });
        Button gravityButton = findViewById(R.id.gravitySensorButton);
        gravityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, GravitySensorActivity.class);
                startActivity(intent);
            }
        });
        Button proximityButton = findViewById(R.id.proximitySensorButton);
        proximityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, ProximityActivity.class);
                startActivity(intent);
            }
        });
        Button orientationButton = findViewById(R.id.orientationSensorButton);
        orientationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, OrientationSensorActivity.class);
                startActivity(intent);
            }
        });
        Button magnetometerButton = findViewById(R.id.magnetometer);
        magnetometerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, MagnetometerActivity.class);
                startActivity(intent);
            }
        });
        Button lightButton = findViewById(R.id.lightSensorButton);
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, LightSensorActivity.class);
                startActivity(intent);
            }
        });
        Button tempButton = findViewById(R.id.temperatureSensorButton);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, TemperatureSensorActivity.class);
                startActivity(intent);
            }
        });
        Button pressButton = findViewById(R.id.pressureSensorButton);
        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, PressureSensorActivity.class);
                startActivity(intent);
            }
        });
        Button HumiButton = findViewById(R.id.humiditySensorButton);
        HumiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sensor.this, HumiditySensorActivity.class);
                startActivity(intent);
            }
        });
    }
}