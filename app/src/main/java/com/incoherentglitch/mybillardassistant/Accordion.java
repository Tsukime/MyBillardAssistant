package com.incoherentglitch.mybillardassistant;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;

public class Accordion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accordion);
        Button findMagicBtn = (Button) findViewById(R.id.magic_btn);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout);
                    if (findMagicLl.getVisibility() == View.VISIBLE) {
                        animationClosing = true;
                        findMagicLl.animate().alpha(0f).setDuration(200).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                findMagicLl.setVisibility(View.GONE);
                                animationClosing = false;
                            }
                        }).start();
                    } else {

                        findMagicLl.setVisibility(View.VISIBLE);
                        findMagicLl.setAlpha(1f);
                    }
                }

            }
        });

        Button findMagicBtn2 = (Button) findViewById(R.id.magic_btn2);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout2);
                if (findMagicLl.getVisibility() == View.VISIBLE) {
                    findMagicLl.setVisibility(View.GONE);
                } else {
                    findMagicLl.setVisibility(View.VISIBLE);
                }
            }
        });

       // findMagicBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow, 0);
    }

}
