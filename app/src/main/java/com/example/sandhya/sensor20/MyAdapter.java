package com.example.sandhya.sensor20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context con;
    LayoutInflater li;
    Integer[] image;
    String[] name;
    public MyAdapter(Context con,Integer[] image,String[] name) {
        this.con = con;
        this.name= name;
        this.image=image;
        li=LayoutInflater.from(con);
    }
    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return image;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    TextView n;
    ImageView iv1;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myview=li.inflate(R.layout.clist,null);
        iv1=myview.findViewById(R.id.iv1);
        n=myview.findViewById(R.id.name);
        n.setText(name[i]);
        return myview;
    }
}
