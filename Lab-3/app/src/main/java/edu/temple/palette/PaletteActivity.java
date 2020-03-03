package edu.temple.palette;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Spinner spinner;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        spinner = findViewById(R.id.spinner);

        final String [] colors = {"WHITE", "BLUE", "GREEN", "YELLOW", "RED"};

        ColorAdapter adapter = new ColorAdapter(this, colors);

        spinner.setAdapter(adapter);

        final ConstraintLayout constraint = (ConstraintLayout) findViewById(R.id.constraint);
        //constraint.setBackgroundColor(Color.BLUE);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                constraint.setBackgroundColor(Color.parseColor((String) colors[i]));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                constraint.setBackgroundColor(Color.WHITE);
            }
        });



}
}
