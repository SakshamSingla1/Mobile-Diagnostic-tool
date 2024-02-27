package com.example.mdt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GyroscopeActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private TextView xValueTextView, yValueTextView, zValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        // Get a reference to the SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get a reference to the gyroscope sensor
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        // Get references to the TextViews that will display the gyroscope data
        xValueTextView = findViewById(R.id.x_value_text_view);
        yValueTextView = findViewById(R.id.y_value_text_view);
        zValueTextView = findViewById(R.id.z_value_text_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Register this class as a listener for the gyroscope sensor
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Unregister this class as a listener for the gyroscope sensor
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Check if the sensor being detected is the gyroscope
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            // Display the x, y, and z values in their respective TextViews
            xValueTextView.setText("X: " + sensorEvent.values[0]);
            yValueTextView.setText("Y: " + sensorEvent.values[1]);
            zValueTextView.setText("Z: " + sensorEvent.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // Do nothing
    }
}
