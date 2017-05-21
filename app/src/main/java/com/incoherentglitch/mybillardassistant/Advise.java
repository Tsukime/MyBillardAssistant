package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Ouvre la page des conseils
 */
public class Advise extends AppCompatActivity {
    private Button bConseilInternet = null;

    /**
     * Création de la vue
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_advise);
        bConseilInternet = (Button) findViewById(R.id.bouton_conseils_internet);
        bConseilInternet.setOnClickListener(clickListenerBoutons);

    }

    /**
     * Création du Listener pour aller sur les conseils internet
     */
    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;

        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
            if(v.getId()==R.id.bouton_conseils_internet) {
                activityTwo = new Intent(Advise.this, ConseilsInternet.class);
                startActivity(activityTwo);
            }
        }
    };
}
