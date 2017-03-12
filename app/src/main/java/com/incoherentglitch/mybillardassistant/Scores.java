package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Scores extends Activity {

    private Button bMenu, bHelp, bRecherche, bNouveau, bFiltres;
    private EditText barreRecherche;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_menu_scores)
            {
                activityTwo = new Intent(Scores.this, Menu.class);
                startActivity(activityTwo);
            }
            /*if(v.getId()==R.id.bouton_nouveau)
            {
                Toast.makeText(Scores.this, "Add score pas encore implémenté D:", Toast.LENGTH_LONG).show();
            }
            if(v.getId()==R.id.bouton_recherche)
            {
                Toast.makeText(Scores.this, "Recherche pas encore implémentée D:", Toast.LENGTH_LONG).show();
            }
            if(v.getId()==R.id.bouton_selectFilters)
            {
                Toast.makeText(Scores.this, "Filtres pas encore implémentés D:", Toast.LENGTH_LONG).show();
            }*/
        }
    };

    private View.OnClickListener clickListenerBoutonHelp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder box = new AlertDialog.Builder(Scores.this);
            box.setCancelable(true);
            box.setMessage(R.string.dialog_help_scores);
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
        setContentView(R.layout.activity_scores);

        barreRecherche = (EditText) findViewById(R.id.barre_recherche);
        bFiltres = (Button) findViewById(R.id.bouton_selectFilters);
        bRecherche = (Button) findViewById(R.id.bouton_recherche);
        bNouveau = (Button) findViewById(R.id.bouton_nouveau);
        bMenu = (Button) findViewById(R.id.bouton_menu_scores);
        bHelp = (Button) findViewById(R.id.bouton_help_scores);

        //barreRecherche.setOnClickListener(clickListenerBoutons);
        bFiltres.setOnClickListener(clickListenerBoutons);
        bRecherche.setOnClickListener(clickListenerBoutons);
        bNouveau.setOnClickListener(clickListenerBoutons);
        bMenu.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);
    }
}
