package edu.temple.myfragcommapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {

    TextView randomDisplay;

    public RandomFragment() {
        // Required empty public constructor
    }

    public void generateNewNumber(){
        randomDisplay.setText(String.valueOf(Math.random() * 100));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_random, container, false);
        randomDisplay = v.findViewById(R.id.randomDisplay);
        return v;
    }

}
