package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bLogin = (Button) findViewById(R.id.bLogin);

        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        registerLink.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v){
                Intent registerIntent = new Intent(Login.this, Register.class);
                Login.this.startActivity(registerIntent);   //ouvre une activité
                }

            }
        );

        final ImageButton ireturn = (ImageButton) findViewById(R.id.iReturn);
        ireturn.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
                                       public void onClick(View v) {
                                           Intent registerIntent = new Intent(Login.this, MainMenu.class);
                                           Login.this.startActivity(registerIntent);   //ouvre une activité
                                       }
                                   }
        );
    }
}
