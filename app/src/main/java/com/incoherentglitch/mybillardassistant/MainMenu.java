package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final TextView rules = (TextView) findViewById(R.id.tvRules);
        final TextView score = (TextView) findViewById(R.id.tvScore);
        final TextView advise = (TextView) findViewById(R.id.tvAdvise);
        final ImageButton option = (ImageButton) findViewById(R.id.iOption);
        final ImageButton account = (ImageButton) findViewById(R.id.iAccount);

        rules.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainMenu.this, Rules.class);
                MainMenu.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );
        score.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainMenu.this, Score.class);
                MainMenu.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );

        advise.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainMenu.this, Advise.class);
                MainMenu.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );

        option.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainMenu.this, Option.class);
                MainMenu.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );

        account.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainMenu.this, Login.class);
                MainMenu.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );
    }
}
