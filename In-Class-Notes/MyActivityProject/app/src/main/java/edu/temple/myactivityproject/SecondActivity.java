package edu.temple.myactivityproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//whenever components want to communicate, use intents
//intents are a messaging feature for activities
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent receivedIntent = getIntent(); //intent from activity 1 gets passed to activity 2. it must be retrieved like this

        String message = receivedIntent.getStringExtra("message"); //takes message from activity 1

        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message); //displays message taken from activity 1

        /*When putting this in onCreate instead of in the setonclick, message gets displayed even if the back button
        * is pressed. It doesn't display if back button is pressed in setonclick*/
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", "Message got displayed");
        setResult(RESULT_OK, resultIntent); //this and previous statement are always sent

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("result", "Message got displayed");
//                setResult(RESULT_OK, resultIntent); //this and previous statement are always sent
                finish();
            }
        });
    }
}
