package com.example.sandhya.sensor20;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class i0 extends AppCompatActivity {
    TextView sv;
    ImageView siv;
    SensorManager sm;
    SensorEventListener sel;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i0);
        sv=findViewById(R.id.sv);
        siv=findViewById(R.id.siv);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(s==null) {
            Toast.makeText(i0.this,"Throw the phone out",Toast.LENGTH_SHORT);
        }
        else {
            sel=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    sv.setText("X = "+event.values[0]+"\nY = "+event.values[1]+"\nZ = "+event.values[2]);
                    if(event.values[0]==0) {
                        sv.setText("Don't touch me");
                    }
                    else {
                        sv.setText("please touch me");
                   }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
            sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}
