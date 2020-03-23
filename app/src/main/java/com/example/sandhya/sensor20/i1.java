package com.example.sandhya.sensor20;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class i1 extends AppCompatActivity {
    TextView sv;
    ImageView siv;
    SensorManager sm;
    SensorEventListener sel;
    Sensor s;
    SensorEvent sensorEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i1);
        sv=findViewById(R.id.sv);
        siv=findViewById(R.id.siv);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        sm.registerListener(sel,
                s, SensorManager.SENSOR_DELAY_NORMAL);
        if(sensorEvent.values[2] > 0.5f) { // anticlockwise
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        } else if(sensorEvent.values[2] < -0.5f) { // clockwise
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }
    }
}
