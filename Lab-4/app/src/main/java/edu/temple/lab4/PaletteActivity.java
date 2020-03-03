package edu.temple.lab4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        GridView gridView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);



        gridView = findViewById(R.id.gridView);

//        final String [] colors = {"WHITE",
//                                  "BLUE",
//                                  "GREEN",
//                                  "YELLOW",
//                                  "RED",
//                                  "BLACK",
//                                  "CYAN",
//                                  "GRAY",
//                                  "MAGENTA",
//                                  "DARKGRAY"};

        Resources res = getResources();
        final String[] englishLabel = res.getStringArray(R.array.array1);
        final String[] displayLabel = res.getStringArray(R.array.array2);

        ColorAdapter adapter = new ColorAdapter(this, englishLabel, displayLabel);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent launchIntent =
                        new Intent(PaletteActivity.this, CanvasActivity.class);
                launchIntent.putExtra("message", (String) englishLabel[i]);

                startActivity(launchIntent);
            }
        });
    }
}
