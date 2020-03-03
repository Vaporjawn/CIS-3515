package edu.temple.lab6;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;


public class PaletteFragment extends Fragment {

    ColorListener select;


    public PaletteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        Context context = getActivity();
        Resources res = context.getResources();
        String[] gridLabels = res.getStringArray(R.array.array1);
        String[] gridLabels2 = res.getStringArray(R.array.array2);
        // Inflate the layout for this fragment
        final GridView gridview = (GridView) v.findViewById(R.id.gridView);





        ColorAdapter adapter = new ColorAdapter(context, gridLabels, gridLabels2);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                select.setColor(s);
            }
        });
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorListener) {
            select = (ColorListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


}
