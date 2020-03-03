package edu.temple.myfragapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentManager fm2 = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction()
        .add(R.id.container1, new ColorFragment()); //call series of methods describing what transaction is

        transaction.commit(); //adds fragment to first container

        FragmentTransaction transaction2 = fm2.beginTransaction()
                .add(R.id.container2, new ColorFragment()); //call series of methods describing what transaction is

        transaction2.commit();
    }
}
