package com.incoherentglitch.mybillardassistant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private int level;

    private ImageView bCompte = null, bOptions = null;
    private Button bRegles = null, bScores = null, bConseils = null, bHelp = null;

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

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
            if(v.getId()==R.id.bouton_compte)
            {
                activityTwo = new Intent(Menu.this, UserArea.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_options)
            {
                activityTwo = new Intent(Menu.this, Option.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_scores)
            {
                activityTwo = new Intent(Menu.this, Scores.class);
                startActivity(activityTwo);
            }
            if(v.getId()==R.id.bouton_conseils)
            {
                activityTwo = new Intent(Menu.this, Advise.class);
                startActivity(activityTwo);
            }
        }
    };

    private View.OnClickListener clickListenerBoutonHelp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder box = new AlertDialog.Builder(Menu.this);
            box.setCancelable(true);
            box.setTitle("Aide");
            box.setMessage("Conditions générales d'utilisation");
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
