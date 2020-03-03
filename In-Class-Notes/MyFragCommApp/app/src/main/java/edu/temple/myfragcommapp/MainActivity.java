package edu.temple.myfragcommapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity{

    //RandomFragment randomFragment;

    FragmentManager fm;

    boolean twoPanes;
    DisplayFragment dFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = !(findViewById(R.id.container2) == null);

//        randomFragment = new RandomFragment();
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.randomContainer, randomFragment).commit();

        fm = getSupportFragmentManager();
        InitiateFragment iFragment = new InitiateFragment();

        fm.beginTransaction().replace(R.id.container1, iFragment).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.initiatorContainer, new InitiateFragment()).commit();



//        findViewById(R.id.newNumberButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                randomFragment.generateNewNumber();
//            }
//        });
    }

    public void buttonClicked(int i){
        //randomFragment.generateNewNumber();

//        DisplayFragment dFragment = new DisplayFragment();
//
//        Bundle bundle = new Bundle(); //key value pair object
//        bundle.putInt("display_number", i);
//
//        dFragment.setArguments(bundle);

//        DisplayFragment dFragment = DisplayFragment.newInstance(i);
//
//        fm.beginTransaction()
//                .replace(R.id.container1, dFragment)
//                .addToBackStack(null)
//                .commit();

        if(!twoPanes){
            dFragment = DisplayFragment.newInstance(0);
            fm.beginTransaction()
                    .replace(R.id.container2, dFragment)
                    .commit();
        }

        else{
            dFragment.displayNumber(i);
        }

        //dFragment.displayNumber(i);

    }

}
