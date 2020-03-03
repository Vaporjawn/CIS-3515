package edu.temple.myfragcommapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InitiateFragment extends Fragment {


    InitiateInterface parent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (InitiateInterface) context;
    }

    public InitiateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_initiate, container, false);

        v.findViewById(R.id.initiateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.buttonClicked();
            }
        });

        return v;
    }

    interface InitiateInterface {
        public void buttonClicked();
    }

}
