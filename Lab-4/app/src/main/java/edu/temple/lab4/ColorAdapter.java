package edu.temple.lab4;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by thtnm on 2/14/2018.
 */

public class ColorAdapter extends BaseAdapter {

    String[] colors;
    Context context;
    String[] display;

    public ColorAdapter(Context context, String[] colors, String[] display){ //manually creating our own adapter
        this.colors = colors;
        this.context = context; //allows us to create views
        this.display = display;
    }

    @Override
    public int getCount() { //returns count of elements
        return colors.length; //primary and secondary color views
    }

    @Override
    public Object getItem(int i) {
        return colors[i]; //returns position
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);

        if (view == null) {
            textView = new TextView(context);
        } else {
            textView = (TextView) view;
        }

        textView.setText(display[position]);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }
}
