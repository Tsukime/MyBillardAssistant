package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Fragment;
import android.widget.Toast;

public class Option extends Activity {
    private Button bMenu = null;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_menu) {
                activityTwo = new Intent(Option.this, Menu.class);
                startActivity(activityTwo);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        bMenu = (Button) findViewById(R.id.bouton_menu);
        bMenu.setOnClickListener(clickListenerBoutons);
    }




    //
   // final ImageButton ireturn = (ImageButton) findViewById(R.id.iReturn);
/*
    ireturn.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
        public void onClick(View v) {
            Intent registerIntent = new Intent(Option.this, Menu.class);
            Option.this.startActivity(registerIntent);   //ouvre une activité
        }
    }
    );*/
}
