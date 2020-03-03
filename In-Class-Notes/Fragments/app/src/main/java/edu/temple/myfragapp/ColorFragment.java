package edu.temple.myfragapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    View v;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //oncreates for fragments are different than on create for activity
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_color, container, false);

        TextView textView = v.findViewById(R.id.textView);

        textView.setText(String.valueOf(Math.random() * 10000));

        return v;
    }

}
