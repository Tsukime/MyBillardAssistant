package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Advise extends AppCompatActivity {
    private Button bConseilInternet = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
        bConseilInternet = (Button) findViewById(R.id.bouton_conseils_internet);
        bConseilInternet.setOnClickListener(clickListenerBoutons);
/*
        final ImageButton ireturn = (ImageButton) findViewById(R.id.iReturn);
        ireturn.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
            public void onClick(View v) {
                Intent registerIntent = new Intent(Advise.this, Menu.class);
                Advise.this.startActivity(registerIntent);   //ouvre une activité
            }
        }
        );*/
    }

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_conseils_internet) {
                activityTwo = new Intent(Advise.this, ConseilsInternet.class);
                startActivity(activityTwo);
            }
        }
    };
}
