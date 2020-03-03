package edu.temple.lab6;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;


public class PaletteActivity extends Activity implements ColorListener{

    PaletteFragment pF;
    CanvasFragment cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        pF = new PaletteFragment();
        cF = new CanvasFragment();


        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.pFragment, pF)
                .addToBackStack(null)
                .commit();


        if(findViewById(R.id.land) != null){
            FragmentManager fm2 = getFragmentManager();
            fm2.beginTransaction()
                    .replace(R.id.cFragment, cF)
                    .commit();
        }

    }

    public void setColor(String c) {
        if(findViewById(R.id.portrait) != null){
            FragmentManager fm3 = getFragmentManager();
            fm3.beginTransaction()
                    .replace(R.id.pFragment, pF)
                    .addToBackStack(null)
                    .commit();
            fm3.executePendingTransactions();
            findViewById(R.id.pFragment).setBackgroundColor(Color.parseColor(c));

        }else if(findViewById(R.id.land) != null){
            findViewById(R.id.cFragment).setBackgroundColor(Color.parseColor(c));
        }

    }
}
