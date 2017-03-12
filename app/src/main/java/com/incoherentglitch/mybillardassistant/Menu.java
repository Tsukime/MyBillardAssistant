package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ImageView;
//import android.view.MotionEvent;
//import android.content.Intent;
import android.widget.Toast;

public class Menu extends Activity {

    private ImageView bCompte = null, bOptions = null;
    private Button bRegles = null, bScores = null, bConseils = null, bHelp = null;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
       // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_regles)
            {
                activityTwo = new Intent(Menu.this, Regles.class);
                startActivity(activityTwo);
            }
            /*if(v.getId()==R.id.bouton_compte)
            {
                Toast.makeText(Menu.this, "Compte pas encore implémenté D:", Toast.LENGTH_LONG).show();
            }
            if(v.getId()==R.id.bouton_options)
            {
                Toast.makeText(Menu.this, "Options pas encore implémentées D:", Toast.LENGTH_LONG).show();
            }*/
            if(v.getId()==R.id.bouton_scores)
            {
                activityTwo = new Intent(Menu.this, Scores.class);
                startActivity(activityTwo);
            }
            /*if(v.getId()==R.id.bouton_conseils)
            {
                Toast.makeText(Menu.this, "Conseils pas encore implémentés D:", Toast.LENGTH_LONG).show();
            }*/
        }
    };

    private View.OnClickListener clickListenerBoutonHelp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder box = new AlertDialog.Builder(Menu.this);
            box.setCancelable(true);
            box.setMessage(R.string.dialog_help_menu);
            box.setTitle("Aide");
            box.setNeutralButton(R.string.bouton_dialog, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getBaseContext(), "help D:", Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog = box.create();
            dialog.show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bCompte = (ImageView) findViewById(R.id.bouton_compte);
        bOptions = (ImageView) findViewById(R.id.bouton_options);
        bRegles = (Button) findViewById(R.id.bouton_regles);
        bScores = (Button) findViewById(R.id.bouton_scores);
        bConseils = (Button) findViewById(R.id.bouton_conseils);
        bHelp = (Button) findViewById(R.id.bouton_help_menu);

        bCompte.setOnClickListener(clickListenerBoutons);
        bOptions.setOnClickListener(clickListenerBoutons);
        bRegles.setOnClickListener(clickListenerBoutons);
        bScores.setOnClickListener(clickListenerBoutons);
        bConseils.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);
    }
}
