package com.example.sandhya.sensor20;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mysensor;
    SensorManager sm;
    SensorEventListener sel;
    List<Sensor>/*template*/los;
    ArrayList itemname=new ArrayList();
    ArrayList itemvendor=new ArrayList();
    Button gotophonesensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("sandhya","I am below the setcontentview");
        // gotophonesensor=findViewById(R.id.gotophonesensar);
        mysensor=findViewById(R.id.mysensor);
        gotophonesensor=findViewById(R.id.gotophonesensor);
        sm= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Log.d("sandhya","I am below sm=");
        los=sm.getSensorList(Sensor.TYPE_ALL);
        Log.d("sandhya","I am after defining los");
        for(int i=0;i<los.size();i++)
        {
            Log.d("sandhya",""+los.get(i).getName());
            itemname.add(los.get(i).getName());
            itemvendor.add(los.get(i).getVendor());
        }
        Log.d("sandhya","after for loop");
        ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,itemname);
        Log.d("sandhya","after Adapter");
        Toast.makeText(MainActivity.this,""+los.size(),Toast.LENGTH_SHORT).show();
        mysensor.setAdapter(ad);
        mysensor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+itemvendor.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        gotophonesensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SensorHome.class);
                startActivity(i);
            }
        });
    }
}
