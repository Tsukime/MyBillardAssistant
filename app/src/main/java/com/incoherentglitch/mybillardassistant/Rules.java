package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        final ImageButton ireturn = (ImageButton) findViewById(R.id.iReturn);
        ireturn.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(Rules.this, MainMenu.class);
                Rules.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );
    }
}
