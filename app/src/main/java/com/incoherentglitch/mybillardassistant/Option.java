package com.incoherentglitch.mybillardassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Option extends Activity {
    private Button bMenu = null;

    private Button langageMain = null, time_ScoreMain = null, time_TipsMain = null, player_LevelMain = null;

    private int langage;
    private int time_Stockage_Score;
    private int time_Stockage_Tips;
    private int player_Level;

    public void setLangage(int new_lang) {
        langage = new_lang;
        // 0 pour le français.
        // 1 pour l'anglais
    }

    public void setTime_Stockage_Score(int time) {
        // Si la valeur est à -1, alors le stockage est effectué indéfiniment.
        time_Stockage_Score = time;
    }

    public void setTime_Stockage_Tips(int time) {
        // Si la valeur est à -1, alors le stockage est effectué indéfiniment.
        time_Stockage_Tips = time;
    }

    public void setPlayer_Level(int newLevel) {
        player_Level = newLevel;
    }

    public int getLangage() {
        return langage;
        // 0 pour le français.
        // 1 pour l'anglais
    }

    public int getTime_Stockage_Score() {
        // Si la valeur est à -1, alors le stockage est effectué indéfiniment.
        return time_Stockage_Score;
    }

    public int getTime_Stockage_Tips() {
        // Si la valeur est à -1, alors le stockage est effectué indéfiniment.
        return time_Stockage_Tips;
    }

    public int getPlayer_Level() {
        return player_Level;
    }



    public void default_Initialisation() {
        setLangage(0);
        setTime_Stockage_Score(7);
        setTime_Stockage_Tips(7);
        setPlayer_Level(0);
    }

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        // private Intent deuxiemeActivite = null;
        @Override
        public void onClick(View v) {
            Intent activityTwo = null;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Button findMagicBtn1 = (Button) findViewById(R.id.magic_btn_langue);
        findMagicBtn1.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_langue);
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

        Button findMagicBtn2 = (Button) findViewById(R.id.magic_btn_temps);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_temps);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.magic_btn_level);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_level);
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
    }
}
