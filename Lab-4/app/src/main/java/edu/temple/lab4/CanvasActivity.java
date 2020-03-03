package edu.temple.lab4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        final Intent receivedIntent = getIntent(); //intent from activity 1 gets passed to activity 2. it must be retrieved like this

        String color = receivedIntent.getStringExtra("message"); //takes message from activity 1

        final ConstraintLayout canvasConstraint = (ConstraintLayout) findViewById(R.id.canvasConstraint);

        canvasConstraint.setBackgroundColor(Color.parseColor((color)));
//        TextView messageTextView = findViewById(R.id.messageTextView);
//        messageTextView.setText(message); //displays message taken from activity 1
    }
}
