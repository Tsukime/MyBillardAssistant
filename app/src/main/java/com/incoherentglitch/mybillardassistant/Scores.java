package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;


public class Scores extends Activity {

    private Button bMenu, bHelp, bRecherche, bFiltres;
    private ImageButton bNouveau;
    private EditText barreRecherche;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if (v.getId() == R.id.bouton_menu_scores) {
                activityTwo = new Intent(Scores.this, Menu.class);
                startActivity(activityTwo);
            }
            /*
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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_scores);

        barreRecherche = (EditText) findViewById(R.id.barre_recherche);
        //bFiltres = (Button) findViewById(R.id.bouton_selectFilters);
        //bRecherche = (Button) findViewById(R.id.bouton_recherche);
        bMenu = (Button) findViewById(R.id.bouton_menu_scores);
        bHelp = (Button) findViewById(R.id.bouton_help_scores);

        //barreRecherche.setOnClickListener(clickListenerBoutons);
        //bFiltres.setOnClickListener(clickListenerBoutons);
        //bRecherche.setOnClickListener(clickListenerBoutons);
        bMenu.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);

        bNouveau = (ImageButton) findViewById(R.id.bouton_nouveau);
        bNouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLoginDialog();
                //createScoreTableRow();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void createScoreTableRow(String nomP, String typeP) { //ajouter les parametres voulus
        /* Find Tablelayout defined in main.xml */
        TableLayout tl = (TableLayout) findViewById(R.id.tableau_scores);
        TableRow tr = new TableRow(Scores.this);

        TableLayout.LayoutParams tableRowParams =
                new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

        //tableRowParams.setMargins(5, 0, 5, 0); //left top right bottom



        View ligneVerticale1 = new View(this);
        ligneVerticale1.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale1.setBackgroundColor(Color.rgb(51, 51, 51));
        View ligneVerticale2 = new View(this);
        ligneVerticale2.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale2.setBackgroundColor(Color.rgb(51, 51, 51));
        View ligneVerticale3 = new View(this);
        ligneVerticale3.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale3.setBackgroundColor(Color.rgb(51, 51, 51));

        TextView nom = new TextView(Scores.this);
        TextView type = new TextView(Scores.this);
        TextView date = new TextView(Scores.this);
        ImageButton edit = new ImageButton(Scores.this);
        ImageButton suppr = new ImageButton(Scores.this);
        nom.setText(nomP);
        nom.setPadding(10, 20, 10, 0);
        type.setText(typeP);
        type.setPadding(10, 20, 10, 0);

        Calendar c = Calendar.getInstance();
        int jour = c.get(Calendar.DAY_OF_MONTH);
        int mois = c.get(Calendar.MONTH)+1; //janvier = 0
        int annee = c.get(Calendar.YEAR);
        date.setText(jour + "/" + mois + "/" + annee);
        date.setPadding(10, 20, 10, 0);

        edit.setBackgroundResource(R.drawable.mini_crayon);
        suppr.setBackgroundResource(R.drawable.mini_croix_rouge);

        tr.addView(ligneVerticale1);
        tr.addView(nom);
        tr.addView(ligneVerticale2);
        tr.addView(type);
        tr.addView(ligneVerticale3);
        tr.addView(date);
        tr.addView(edit);
        tr.addView(suppr);

        View ligneHorizontale1 = new View(this);
        ligneHorizontale1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 2));
        ligneHorizontale1.setBackgroundColor(Color.rgb(51, 51, 51));
        ligneHorizontale1.getMeasuredWidth();
        View ligneHorizontale2 = new View(this);
        ligneHorizontale2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 2));
        ligneHorizontale2.setBackgroundColor(Color.rgb(51, 51, 51));

        tl.addView(ligneHorizontale1);
      //  tl.addView(ligneHorizontale1, new TableLayout.LayoutParams(tr.getMeasuredWidth(), 2));
        tl.addView(tr, tableRowParams);
        tl.addView(ligneHorizontale2);
    }

    private void callLoginDialog() {
        final Dialog myDialog = new Dialog(Scores.this);
        myDialog.setContentView(R.layout.create_score);
        myDialog.setCancelable(true);
        Button valider = (Button) myDialog.findViewById(R.id.partie_valider);
        final EditText partieNom = (EditText) myDialog.findViewById(R.id.partie_nom);
        final EditText partieType = (EditText) myDialog.findViewById(R.id.partie_type);

        myDialog.show();

        partieNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                partieNom.setText("");
            }
        });
        partieType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                partieType.setText("");
            }
        });
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createScoreTableRow(partieNom.getText().toString(), partieType.getText().toString());
                myDialog.dismiss();
            }
        });

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Scores Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
