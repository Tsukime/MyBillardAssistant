package com.incoherentglitch.mybillardassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class ReglesAmericain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regles_americain);
    }
}
