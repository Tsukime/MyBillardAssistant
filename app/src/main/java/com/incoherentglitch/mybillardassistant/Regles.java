package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Regles extends Activity {

    private Button bMenu = null;
    private ImageButton bBillardFrancais = null, bBillardAmericain = null, bPoolAnglais = null, bSnooker = null;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_menu_regles) {
                activityTwo = new Intent(Regles.this, Menu.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_poolAnglais) {
                activityTwo = new Intent(Regles.this, ReglesAnglais.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_billardFrancais) {
                activityTwo = new Intent(Regles.this, ReglesFrancais.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_billardAmericain) {
                activityTwo = new Intent(Regles.this, ReglesAmericain.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_snooker) {
                activityTwo = new Intent(Regles.this, ReglesSnooker.class);
                startActivity(activityTwo);
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regles);

        bMenu = (Button) findViewById(R.id.bouton_menu_regles);
        bBillardFrancais = (ImageButton) findViewById(R.id.bouton_billardFrancais);
        bBillardAmericain = (ImageButton) findViewById(R.id.bouton_billardAmericain);
        bPoolAnglais = (ImageButton) findViewById(R.id.bouton_poolAnglais);
        bSnooker = (ImageButton) findViewById(R.id.bouton_snooker);

        bMenu.setOnClickListener(clickListenerBoutons);
        bBillardFrancais.setOnClickListener(clickListenerBoutons);
        bBillardAmericain.setOnClickListener(clickListenerBoutons);
        bPoolAnglais.setOnClickListener(clickListenerBoutons);
        bSnooker.setOnClickListener(clickListenerBoutons);
    }
}
