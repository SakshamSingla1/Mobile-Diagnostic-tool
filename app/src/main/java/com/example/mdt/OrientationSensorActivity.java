package com.example.mdt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrientationSensorActivity extends AppCompatActivity implements SensorEventListener {


        private SensorManager sensorManager;
        private Sensor orientationSensor;
        private TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_orientation_sensor);

            // Get a reference to the SensorManager
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

            // Get a reference to the Orientation sensor
            orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

            // Get a reference to the TextView that will display the sensor values
            textView = findViewById(R.id.sensor_values);
        }

        @Override
        protected void onResume() {
            super.onResume();
            // Register this activity as the listener for the Orientation sensor
            sensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        @Override
        protected void onPause() {
            super.onPause();
            // Unregister this activity as the listener for the Orientation sensor
            sensorManager.unregisterListener(this);
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // Update the TextView with the new sensor values
            textView.setText("Yaw: " + event.values[0] + "\nPitch: " + event.values[1] + "\nRoll: " + event.values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Do nothing
        }
    }
