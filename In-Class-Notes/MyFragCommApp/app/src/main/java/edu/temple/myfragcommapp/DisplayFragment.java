package edu.temple.myfragcommapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment {
    TextView randomDisplay;

    int number;

    public static String NUMBER_KEY = "display_number";

    public DisplayFragment()
    {

    }

    public static DisplayFragment newInstance(int number){
        DisplayFragment dFragment = new DisplayFragment();

        Bundle bundle = new Bundle(); //key value pair object
        bundle.putInt(NUMBER_KEY, number);

        dFragment.setArguments(bundle);

        return dFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceStatae){
        super.onCreate(savedInstanceStatae);

        Bundle bundle = getArguments();
        if (bundle.containsKey(NUMBER_KEY))
            number = bundle.getInt(NUMBER_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_random, container);
        randomDisplay = v.findViewById(R.id.randomDisplay);
        displayNumber(number);
        return v;
    }

    public void displayNumber(int i){
        randomDisplay.setText(String.valueOf(i));
    }

}
