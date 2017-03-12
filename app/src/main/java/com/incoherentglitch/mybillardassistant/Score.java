package com.incoherentglitch.mybillardassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final ImageButton ireturn = (ImageButton) findViewById(R.id.iReturn);
        ireturn.setOnClickListener(new View.OnClickListener() { //appelle les instruction dans OnClick ci-dessus quand cliqué
                                     public void onClick(View v) {
                                         Intent registerIntent = new Intent(Score.this, MainMenu.class);
                                         Score.this.startActivity(registerIntent);   //ouvre une activité
                                     }
                                 }
        );
    }
}
