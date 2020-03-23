package com.example.sandhya.sensor20;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SensorHome extends AppCompatActivity {
    ListView list;
    Integer[] image={R.drawable.aaa,R.drawable.gg,R.drawable.mm,R.drawable.mm,R.drawable.li,R.drawable.bbb,R.drawable.aaa,R.drawable.mm,R.drawable.li};
    String[] name={"Accelometer","Gyroscope","Megnetometer","Proximity Sensor","Light Sensor","Barometer","Thermometer","Air Humid Sensor","Fingerprint Sensor"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_home);
        list=findViewById(R.id.list);
        MyAdapter ma=new MyAdapter(SensorHome.this,image,name);
        list.setAdapter(ma);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i==0) {
                   Intent i22=new Intent(SensorHome.this,i0.class);
                   startActivity(i22);
               }
               else if(i==1) {
                   Intent i1=new Intent(SensorHome.this,i1.class);
                   startActivity(i1);
               }
               else if(i==2) {
                   Intent i2=new Intent(SensorHome.this,i2.class);
                   startActivity(i2);
               }
               else if(i==3) {
                   Intent i3=new Intent(SensorHome.this,i3.class);
                   startActivity(i3);
               }
               else if(i==4) {
                   Intent i4=new Intent(SensorHome.this,i4.class);
                   startActivity(i4);
               }
               else if(i==5) {
                   Intent i5=new Intent(SensorHome.this,i5.class);
                   startActivity(i5);
               }
               else if(i==6) {
                   Intent i6=new Intent(SensorHome.this,i7.class);
                   startActivity(i6);
               }
               else if(i==7) {
                   Intent i7=new Intent(SensorHome.this,i7.class);
                   startActivity(i7);
               }
               else if(i==8) {
                   Intent i8=new Intent(SensorHome.this,i8.class);
                   startActivity(i8);
               }
            }
        });

    }
}
