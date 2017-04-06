package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class Scores extends Activity {

    private Button bMenu, bHelp, bRecherche, bFiltres;
    private ImageButton bNouveau;
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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_scores);

        barreRecherche = (EditText) findViewById(R.id.barre_recherche);
        //bFiltres = (Button) findViewById(R.id.bouton_selectFilters);
        //bRecherche = (Button) findViewById(R.id.bouton_recherche);
        bNouveau = (ImageButton) findViewById(R.id.bouton_nouveau);
        bMenu = (Button) findViewById(R.id.bouton_menu_scores);
        bHelp = (Button) findViewById(R.id.bouton_help_scores);

        //barreRecherche.setOnClickListener(clickListenerBoutons);
        //bFiltres.setOnClickListener(clickListenerBoutons);
        //bRecherche.setOnClickListener(clickListenerBoutons);
        bNouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Find Tablelayout defined in main.xml */
                TableLayout tl = (TableLayout) findViewById(R.id.tableau_scores);
                /* Create a new row to be added. */
                TableRow tr = new TableRow(Scores.this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                /* Create a Button to be the row-content. */
                TextView nom = new TextView(Scores.this);
                TextView type = new TextView(Scores.this);
                TextView date = new TextView(Scores.this);
                ImageButton edit = new ImageButton(Scores.this);
                ImageButton suppr = new ImageButton(Scores.this);
                nom.setText("nom partie");
                nom.setPadding(0, 20, 0, 0);
                type.setText("type partie");
                date.setText("date partie");
                edit.setBackgroundResource(R.drawable.mini_crayon);
                edit.setMaxWidth(20);
                suppr.setBackgroundResource(R.drawable.mini_croix_rouge);
                tr.addView(nom);
                tr.addView(type);
                tr.addView(date);
                tr.addView(edit);
                tr.addView(suppr);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        });
        bMenu.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);
    }
}
