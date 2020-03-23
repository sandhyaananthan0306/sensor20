package com.example.sandhya.sensor20;

import android.arch.lifecycle.Lifecycle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandhya.sensor20.i4;

import org.w3c.dom.Text;

public class i4 extends AppCompatActivity {
    TextView sv;
    ImageView siv;
    SensorManager sm;
    SensorEventListener sel;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i4);
        sv=findViewById(R.id.sv);
        siv=findViewById(R.id.siv);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(s==null) {
            Toast.makeText(i4.this,"Throw the phone out",Toast.LENGTH_SHORT);
        }
        else {
            sel=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    sv.setText(""+event.values[0]);
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
            sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}

