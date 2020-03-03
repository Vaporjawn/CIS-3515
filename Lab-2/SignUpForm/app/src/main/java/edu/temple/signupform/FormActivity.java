package edu.temple.signupform;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final EditText myName = findViewById(R.id.Name);
        final EditText myEmail = findViewById(R.id.Email);
        final EditText myPass = findViewById(R.id.Password);
        final EditText myPassConf = findViewById(R.id.PasswordConfirmation);
        Button myButton = findViewById(R.id.Save);

        // Create listener for click event
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myName.getText().toString();
                String email = myEmail.getText().toString();
                String pass = myPass.getText().toString();
                String passConf = myPassConf.getText().toString();

                if(name.equals("") ||
                        email.equals("") ||
                        pass.equals("") ||
                        passConf.equals(""))
                {
                    Toast t = Toast.makeText(FormActivity.this, "Please enter all fields", Toast.LENGTH_SHORT);
                    t.show();
                }

                else if(!(pass.equals(passConf)))
                {
                    Toast t = Toast.makeText(FormActivity.this, "Error: Passwords don't match", Toast.LENGTH_SHORT);
                    t.show();
                }

                else
                {
                    Toast t = Toast.makeText(FormActivity.this, "Your information has been saved", Toast.LENGTH_SHORT);
                    t.show();
                }


            }
        };

        myButton.setOnClickListener(ocl);

    }
}
