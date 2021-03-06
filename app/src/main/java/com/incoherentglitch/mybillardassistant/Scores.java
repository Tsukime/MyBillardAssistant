package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Page des scores
 */
public class Scores extends Activity {

    private Button bMenu, bHelp;
    private ImageButton bNouveau, bDeleteBDD;

    private PartieDataSource datasource;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if (v.getId() == R.id.bouton_menu_scores) {
                activityTwo = new Intent(Scores.this, Menu.class);
                startActivity(activityTwo);
            }
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

        bMenu = (Button) findViewById(R.id.bouton_menu_scores);
        bHelp = (Button) findViewById(R.id.bouton_help_scores);

        bMenu.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);

        bNouveau = (ImageButton) findViewById(R.id.bouton_nouveau);
        bNouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLoginDialog();
            }
        });

        datasource = new PartieDataSource(Scores.this);
        ArrayList<Partie> result = datasource.load();

        for (Partie partie : result){
            createScoreTableRow(partie.getName(), partie.getType(), partie.getScores(), partie.getDate());
        }

        bDeleteBDD = (ImageButton) findViewById(R.id.bouton_deleteBDD);
        bDeleteBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datasource.deleteBDD();
                finish();
                startActivity(getIntent());
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Créer une ligne dans le table des Scores de la vue
     * @param nomP : nom de la Partie
     * @param typeP : type de la Partie
     * @param scoreP : score de la Partie
     * @param dateP : date de la Partie au format jj/mm/aaaa
     */
    private void createScoreTableRow(String nomP, String typeP, String scoreP, String dateP) {
        /* Find Tablelayout defined in main.xml */
        TableLayout tl = (TableLayout) findViewById(R.id.tableau_scores);
        TableRow tr = new TableRow(Scores.this);

        TableLayout.LayoutParams tableRowParams =
                new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

        View ligneVerticale1 = new View(this);
        ligneVerticale1.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale1.setBackgroundColor(Color.rgb(51, 51, 51));
        View ligneVerticale2 = new View(this);
        ligneVerticale2.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale2.setBackgroundColor(Color.rgb(51, 51, 51));
        View ligneVerticale3 = new View(this);
        ligneVerticale3.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale3.setBackgroundColor(Color.rgb(51, 51, 51));
        View ligneVerticale4 = new View(this);
        ligneVerticale4.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));
        ligneVerticale4.setBackgroundColor(Color.rgb(51, 51, 51));

        TextView nom = new TextView(Scores.this);
        TextView type = new TextView(Scores.this);
        TextView date = new TextView(Scores.this);
        TextView score = new TextView(Scores.this);

        nom.setText(nomP);
        nom.setPadding(10, 20, 10, 0); //left top right bottom
        type.setText(typeP);
        type.setPadding(10, 20, 10, 0);
        score.setText(scoreP);
        score.setPadding(10, 20, 10, 0);
        date.setText(dateP);
        date.setPadding(10, 20, 10, 0);

        tr.addView(ligneVerticale1);
        tr.addView(nom);
        tr.addView(ligneVerticale2);
        tr.addView(type);
        tr.addView(ligneVerticale3);
        tr.addView(date);
        tr.addView(ligneVerticale4);
        tr.addView(score);

        View ligneHorizontale1 = new View(this);
        ligneHorizontale1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 2));
        ligneHorizontale1.setBackgroundColor(Color.rgb(51, 51, 51));
        ligneHorizontale1.getMeasuredWidth();
        View ligneHorizontale2 = new View(this);
        ligneHorizontale2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 2));
        ligneHorizontale2.setBackgroundColor(Color.rgb(51, 51, 51));

        tl.addView(ligneHorizontale1);
        tl.addView(tr, tableRowParams);
        tl.addView(ligneHorizontale2);
    }

    /**
     * Ouvre la boite de dialogue contenant le formlulaire pour créer la partie
     */
    private void callLoginDialog() {
        final Dialog myDialog = new Dialog(Scores.this);
        myDialog.setContentView(R.layout.create_score);
        myDialog.setCancelable(true);
        Button valider = (Button) myDialog.findViewById(R.id.partie_valider);
        final EditText partieNom = (EditText) myDialog.findViewById(R.id.partie_nom);
        final EditText partieType = (EditText) myDialog.findViewById(R.id.partie_type);
        final EditText partieScore = (EditText) myDialog.findViewById(R.id.partie_score);

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
        partieScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                partieScore.setText("");
            }
        });
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int jour = c.get(Calendar.DAY_OF_MONTH);
                int mois = c.get(Calendar.MONTH)+1; //janvier = 0
                int annee = c.get(Calendar.YEAR);

                String nom_partie = partieNom.getText().toString();
                String type_partie = partieType.getText().toString();
                String score_partie = partieScore.getText().toString();
                String datePartie = jour + "/" + mois + "/" + annee;

                datasource = new PartieDataSource(Scores.this);
                datasource.insert(nom_partie, datePartie, type_partie, score_partie);

                createScoreTableRow(nom_partie, type_partie, score_partie, datePartie);

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

}
