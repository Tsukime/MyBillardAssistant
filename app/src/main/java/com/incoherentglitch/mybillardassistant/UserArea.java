package com.incoherentglitch.mybillardassistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class UserArea extends AppCompatActivity {
    EditText etUsername;
    EditText etAge;
    TextView weclcomMess;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_area);
        System.out.println("coucou compte");

        etUsername = (EditText) findViewById(R.id.etUsername);
        etAge = (EditText) findViewById(R.id.etAge);
        weclcomMess = (TextView) findViewById(R.id.tvWelcomMessage);

    }

}
