package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

        private SensorManager sensorManager;
        private Sensor lightSensor;
        private TextView lightValueTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_light_sensor);

            // Get references to views
            lightValueTextView = findViewById(R.id.light_value);

            // Get sensor manager
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

            // Get light sensor
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }

        @Override
        protected void onResume() {
            super.onResume();
            // Register listener to receive updates from light sensor
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        @Override
        protected void onPause() {
            super.onPause();
            // Unregister listener to stop receiving updates from light sensor
            sensorManager.unregisterListener(this);
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                float lightValue = event.values[0];
                // Update text view with current light sensor value
                lightValueTextView.setText("Light Sensor Value: " + lightValue);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Do nothing
        }
    }