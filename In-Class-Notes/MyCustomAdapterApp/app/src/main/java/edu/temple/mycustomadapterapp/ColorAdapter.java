package edu.temple.mycustomadapterapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by thtnm on 2/6/2018.
 */

public class ColorAdapter extends BaseAdapter {

    String[] colors;
    Context context;

    public ColorAdapter(Context context, String[] colors){ //manually creating our own adapter
        this.colors = colors;
        this.context = context; //allows us to create views
    }

    @Override
    public int getCount() { //returns count of elements
        return colors.length + 2; //primary and secondary color views
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
        view = null;

        if(position == 0){
            TextView textView = new TextView(context);
            textView.setText("PRIMARY");
            LinearLayout ll = new LinearLayout(context);
            ll.addView(textView);
            view = ll;
        }
        else if(position == 4){
            TextView textView = new TextView(context);
            textView.setText("SECONDARY");
            LinearLayout ll = new LinearLayout(context);
            ll.addView(textView);
            view = ll;
        }
        else {

            if (view == null) {
                view = new TextView(context);
            } else {
                view = (TextView) view;
            }

            ((TextView) view).setText(colors[position < 4 ? position - 1: position - 2]);
//            textView.setText(colors[position]);
            ((TextView) view).setBackgroundColor(Color.parseColor(colors[position < 4 ? position - 1: position - 2]));
//            textView.setBackgroundColor(Color.parseColor(colors[position]));
        }
        return view;


        //        TextView textView = new TextView(context);
//
//        if(position == 0){
//            textView = new TextView(context);
//            textView.setText("PRIMARY");
//        }
//        else if(position == 4){
//            textView = new TextView(context);
//            textView.setText("SECONDARY");
//        }
//        else {
//
//            if (view == null) {
//            textView = new TextView(context);
//        } else {
//            textView = (TextView) view;
//        }
//
//        textView.setText(colors[position < 4 ? position - 1: position - 2]);
////            textView.setText(colors[position]);
//        textView.setBackgroundColor(Color.parseColor(colors[position < 4 ? position - 1: position - 2]));
////            textView.setBackgroundColor(Color.parseColor(colors[position]));
//    }
//        return textView;

//        TextView textView = new TextView(context);
//        return textView;
//
//        if (view == null) {
//            textView = new TextView(context);
//        } else {
//            textView = (TextView) view;
//        }
//
//        textView.setText(colors[position]);
//        textView.setBackgroundColor(Color.parseColor(colors[position]));
//    }
//
//        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) { //show dropdown colors without text, only colors
        TextView textView = (TextView) getView(position, convertView, parent);
        textView.setText("");
        return textView;
    }
}







//public class ColorAdapter extends ArrayAdapter {
//
//    Object[] colors;
//
//    public ColorAdapter(Context context, int resource, Object[] colors) {
//        super(context, resource, colors);
//
//        this.colors = colors;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = super.getView(position, convertView, parent);
//        v.setBackgroundColor(Color.parseColor((String) colors[position]));
//        return v;
//    }
//
//
//
//}