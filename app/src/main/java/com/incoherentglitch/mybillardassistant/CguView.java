package com.incoherentglitch.mybillardassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

/**
 * Ouvre la page des CGU
 */
public class CguView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView vue = new WebView(this);
        String pdfUrl = "https://tsukime.github.io/cgu_v1.pdf";
        String url = "https://docs.google.com/gview?embedded=true&url=" + pdfUrl;

        vue.getSettings().setJavaScriptEnabled(true);

        setContentView(vue);

        vue.loadUrl(url);
    }

}
