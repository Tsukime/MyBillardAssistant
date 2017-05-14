package com.incoherentglitch.mybillardassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class ReglesFrancais extends AppCompatActivity {
    Vector<TextView> array = new Vector<TextView>();
    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 18;

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
    int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regles_francais);

        ViewGroup layout = ( (ViewGroup) findViewById(R.id.layout_general));
        findAllTextViews(layout);

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

        Button findMagicBtn = (Button) findViewById(R.id.Introduction);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.Intro);
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


        Button findMagicBtn2 = (Button) findViewById(R.id.DebutPartie);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.DebutPartieContent);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.PosiDepart);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PosiDepartContent);
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

        Button findMagicBtn4 = (Button) findViewById(R.id.Interruption);
        findMagicBtn4.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.InterruptionContent);
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

        Button findMagicBtn5 = (Button) findViewById(R.id.BilleContact);
        findMagicBtn5.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleContactContent);
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

        Button findMagicBtn6 = (Button) findViewById(R.id.BilleContact1);
        findMagicBtn6.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleContactContent1);
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

        Button findMagicBtn7 = (Button) findViewById(R.id.BilleContact2);
        findMagicBtn7.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleContactContent2);
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

        Button findMagicBtn8 = (Button) findViewById(R.id.BilleContact3);
        findMagicBtn8.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleContactContent3);
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
        Button findMagicBtn9 = (Button) findViewById(R.id.BilleContact4);
        findMagicBtn9.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleContactContent4);
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

        Button findMagicBtnA = (Button) findViewById(R.id.BilleHors);
        findMagicBtnA.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleHorsContent);
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


        Button findMagicBtnB = (Button) findViewById(R.id.Queue);
        findMagicBtnB.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.QueueContent);
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

        Button findMagicBtnC = (Button) findViewById(R.id.Faute);
        findMagicBtnC.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.FauteContent);
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

        Button findMagicBtnD = (Button) findViewById(R.id.Annonce);
        findMagicBtnD.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.AnnonceContent);
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

        Button findMagicBtnE = (Button) findViewById(R.id.ManipBille);
        findMagicBtnE.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.ManipBilleContent);
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

        Button findMagicBtnF = (Button) findViewById(R.id.Feuille);
        findMagicBtnF.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.FeuilleContent);
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

        Button findMagicBtnG = (Button) findViewById(R.id.PassageMain);
        findMagicBtnG.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PassageMainContent);
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

        Button findMagicBtnH = (Button) findViewById(R.id.Nettoyagge);
        findMagicBtnH.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.NettoyageContent);
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

        Button findMagicBtnI = (Button) findViewById(R.id.Information);
        findMagicBtnI.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.InformationContent);
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

        Button findMagicBtnJ = (Button) findViewById(R.id.Littige);
        findMagicBtnJ.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.LittigeContent);
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

        Button findMagicBtnK = (Button) findViewById(R.id.Reclamation);
        findMagicBtnK.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.ReclamationContent);
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

        Button findMagicBtnL = (Button) findViewById(R.id.Fin);
        findMagicBtnL.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.FinContent);
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

        Button findMagicBtnM = (Button) findViewById(R.id.Attitude);
        findMagicBtnM.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.AttitudeContent);
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

        Button findMagicBtnN = (Button) findViewById(R.id.Cas);
        findMagicBtnN.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.CasContent);
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
