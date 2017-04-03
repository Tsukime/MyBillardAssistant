package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
