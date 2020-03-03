package edu.temple.lab6;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by thtnm on 2/14/2018.
 */

public class ColorAdapter extends BaseAdapter {

    private String colors[];
    private String colors2[];
    private Context context;

    private LayoutInflater inflater;

    public ColorAdapter(Context context, String colors[], String colors2[]){
        this.context = context;
        this.colors = colors;
        this.colors2 = colors2;
    }



    @Override
    public int getCount() {

        return colors2.length;
    }

    @Override
    public Object getItem(int position) {

        return colors2[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text1 = new TextView(context);
        text1.setText(colors[position]);
        text1.setBackgroundColor(Color.parseColor(colors2[position]));

        return text1;
    }
}
