package com.incoherentglitch.mybillardassistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

/**
 * Page des règles pour le billard anglais
 */
public class ReglesAnglais extends AppCompatActivity {

    Vector<TextView> array = new Vector<TextView>();
    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 18;

    /**
     * Récupère récursivement tous les éléments de type TextView dans un Vector
     * @param viewGroup : la vue de départ
     */
    private void findAllTextViews(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof Button){} // if (!(view instanceof Button) && (view instanceof ViewGroup)) don't work
            else if (view instanceof ViewGroup)
                findAllTextViews((ViewGroup) view);
            else if (view instanceof TextView) {
                TextView edittext = (TextView) view;
                array.add(edittext);
            }
        }

    }

    /**
     * Fonction pour calcul de zoom
     * @param event
     * @return distance parcouru lors de l'event
     */
    int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regles_anglais);

        ViewGroup layout = ( (ViewGroup) findViewById(R.id.layout_general_anglais));
        findAllTextViews(layout);

        //zoom
        layout.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getPointerCount() == 2) {
                    int action = event.getAction();
                    int pureaction = action & MotionEvent.ACTION_MASK;
                    if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                        mBaseDist = getDistance(event);
                        mBaseRatio = mRatio;
                    } else {
                        float delta = (getDistance(event) - mBaseDist) / STEP;
                        float multi = (float) Math.pow(2, delta);
                        mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
                        for (TextView text: array) {
                            text.setTextSize(mRatio + fontsize);
                        }
                    }

                }
                return false;
            }
        });

        //système accordéon
        Button findMagicBtn = (Button) findViewById(R.id.magic_btn_intro);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_intro);
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

        Button findMagicBtn2 = (Button) findViewById(R.id.magic_btn_but_du_jeu);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_but_du_jeu);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.magic_btn_depart);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_depart);
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

        Button findMagicBtn4 = (Button) findViewById(R.id.magic_btn_couleur);
        findMagicBtn4.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_couleur);
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

        Button findMagicBtn5 = (Button) findViewById(R.id.magic_btn_tir_reglementaire);
        findMagicBtn5.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_tir_reglementaire);
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

        Button findMagicBtn6 = (Button) findViewById(R.id.magic_btn_snook_state);
        findMagicBtn6.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_snook_state);
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

        Button findMagicBtn7first = (Button) findViewById(R.id.magic_btn_snook_total);
        findMagicBtn7first.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_snook_total);
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

        Button findMagicBtn7 = (Button) findViewById(R.id.magic_btn_fautes);
        findMagicBtn7.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes);
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

        Button findMagicBtn8 = (Button) findViewById(R.id.magic_btn_fautes_standart);
        findMagicBtn8.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes_standart);
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

        Button findMagicBtn9 = (Button) findViewById(R.id.magic_btn_fautes_non_standart);
        findMagicBtn9.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes_non_standart);
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

        Button findMagicBtn10 = (Button) findViewById(R.id.magic_btn_fautes_snooker);
        findMagicBtn10.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes_snooker);
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

        Button findMagicBtn11 = (Button) findViewById(R.id.magic_btn_fautes_graves);
        findMagicBtn11.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes_graves);
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

        Button findMagicBtn12 = (Button) findViewById(R.id.magic_btn_penalites);
        findMagicBtn12.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_penalites);
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

        Button findMagicBtn13 = (Button) findViewById(R.id.magic_btn_fautes_perte);
        findMagicBtn13.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_fautes_perte);
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

        Button findMagicBtn14 = (Button) findViewById(R.id.magic_btn_aide);
        findMagicBtn14.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_aide);
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

        Button findMagicBtn15 = (Button) findViewById(R.id.magic_btn_controle);
        findMagicBtn15.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_controle);
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

        Button findMagicBtn16 = (Button) findViewById(R.id.magic_btn_contact);
        findMagicBtn16.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_contact);
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

        Button findMagicBtn17 = (Button) findViewById(R.id.magic_btn_interference);
        findMagicBtn17.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_interference);
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

        Button findMagicBtn18 = (Button) findViewById(R.id.magic_btn_repere);
        findMagicBtn18.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_repere);
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

        Button findMagicBtn19 = (Button) findViewById(R.id.magic_btn_impossible);
        findMagicBtn19.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_impossible);
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

        Button findMagicBtn20 = (Button) findViewById(R.id.magic_btn_impasse);
        findMagicBtn20.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;
            @Override
            public void onClick(View v) {
                if (!animationClosing){
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_impasse);
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
