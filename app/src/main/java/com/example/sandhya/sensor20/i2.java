package com.example.sandhya.sensor20;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class i2 extends AppCompatActivity implements SensorEventListener{
    private TextView value;
    private SensorManager sensorManager;
    public static DecimalFormat DECIMAL_FORMATTER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i2);
        value = (TextView) findViewById(R.id.value);
        // define decimal formatter
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DECIMAL_FORMATTER = new DecimalFormat("#.000", symbols);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            // get values for each axes X,Y,Z
            float magX = event.values[0];
            float magY = event.values[1];
            float magZ = event.values[2];
            double magnitude = Math.sqrt((magX * magX) + (magY * magY) + (magZ * magZ));
            // set value on the screen
            value.setText(DECIMAL_FORMATTER.format(magnitude) + " \u00B5Tesla");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
