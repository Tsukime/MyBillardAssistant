package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Regles extends Activity {

    private Button bMenu = null, bHelp = null;
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
            else
            {
                Toast.makeText(Regles.this, "Manque joli image/icone du billard en question", Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener clickListenerBoutonHelp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder box = new AlertDialog.Builder(Regles.this);
            box.setCancelable(true);
            box.setMessage(R.string.dialog_help_regles);
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
        setContentView(R.layout.activity_regles);

        bMenu = (Button) findViewById(R.id.bouton_menu_regles);
        bBillardFrancais = (ImageButton) findViewById(R.id.bouton_billardFrancais);
        bBillardAmericain = (ImageButton) findViewById(R.id.bouton_billardAmericain);
        bPoolAnglais = (ImageButton) findViewById(R.id.bouton_poolAnglais);
        bSnooker = (ImageButton) findViewById(R.id.bouton_snooker);
        bHelp = (Button) findViewById(R.id.bouton_help_regles);

        bMenu.setOnClickListener(clickListenerBoutons);
        bBillardFrancais.setOnClickListener(clickListenerBoutons);
        bBillardAmericain.setOnClickListener(clickListenerBoutons);
        bPoolAnglais.setOnClickListener(clickListenerBoutons);
        bSnooker.setOnClickListener(clickListenerBoutons);
        bHelp.setOnClickListener(clickListenerBoutonHelp);
    }
}
