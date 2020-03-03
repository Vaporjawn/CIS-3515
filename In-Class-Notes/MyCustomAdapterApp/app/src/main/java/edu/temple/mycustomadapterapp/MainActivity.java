package edu.temple.mycustomadapterapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        GridView gridView;
//        Spinner spinner;
        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        gridView = findViewById(R.id.gridView);
//        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        String [] colors = {"Blue", "Teal", "Magenta", "Fuchsia", "Maroon", "Green", "Olive"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                colors
//        );

//        ArrayAdapter<String> adapter = new ColorAdapter(
//                this,
//                android.R.layout.simple_list_item_1,
//                colors
//        );
//
//        gridView.setAdapter(adapter);
//    }

        ColorAdapter adapter = new ColorAdapter(
                this, colors);

        //gridView.setAdapter(adapter);
        //spinner.setAdapter(adapter);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(view instanceof TextView){
                    Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
