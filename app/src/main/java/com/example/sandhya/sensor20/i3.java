package com.example.sandhya.sensor20;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class i3 extends AppCompatActivity {
    TextView sv;
    SensorManager sensorManager;
    Sensor Sensor;
    SensorEventListener SensorEventListener;
    SensorEvent sensorEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i3);
        sv=findViewById(R.id.sv);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximitySensor == null) {
            Toast.makeText(this, "Proximity sensor not available.", Toast.LENGTH_SHORT).show();
        }
        SensorEventListener proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                // More code goes here
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        sensorManager.registerListener(proximitySensorListener,
                proximitySensor, 2 * 1000 * 1000);

        sensorManager.unregisterListener(proximitySensorListener);
        if(sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
            // Detected something nearby
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else {
            // Nothing is nearby
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
    }
}
