package com.example.mdt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureSensorActivity extends AppCompatActivity implements SensorEventListener {

    private TextView mTemperatureTextView;
    private SensorManager mSensorManager;
    private Sensor mTemperatureSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_sensor);

        // Initialize TextView
        mTemperatureTextView = findViewById(R.id.temperatureTextView);

        // Get sensor service and sensor
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mTemperatureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        // Show warning if temperature sensor is not available
        if (mTemperatureSensor == null) {
            Toast.makeText(this, "Temperature sensor is not available on this device", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register listener to temperature sensor
        if (mTemperatureSensor != null) {
            mSensorManager.registerListener(this, mTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister listener when the activity is paused
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Get temperature value from sensor event
        float temperatureValue = event.values[0];
        // Update TextView with temperature value
        mTemperatureTextView.setText(getString(R.string.temperature_label, temperatureValue));

        // Show warning if temperature value is too high (i.e. phone is heating up)
        if (temperatureValue > 40) {
            Toast.makeText(this, "Phone is heating up!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing
    }
}
