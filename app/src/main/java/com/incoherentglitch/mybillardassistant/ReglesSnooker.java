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

public class ReglesSnooker extends AppCompatActivity {
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
        setContentView(R.layout.activity_regles_snooker);
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

        Button findMagicBtn = (Button) findViewById(R.id.Description);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.DescriptionContent);
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

        Button findMagicBtn1 = (Button) findViewById(R.id.PosiBille);
        findMagicBtn1.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PosiBilleContent);
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
        Button findMagicBtn2 = (Button) findViewById(R.id.PrincipeSnook);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PrincipeSnookContent);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.RemiseSnook);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.RemiseSnookContent);
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

        Button findMagicBtn4 = (Button) findViewById(R.id.ToucheSim);
        findMagicBtn4.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.ToucheSimContent);
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

        Button findMagicBtn5 = (Button) findViewById(R.id.RemiCoul);
        findMagicBtn5.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.RemiCoulContent);
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

        Button findMagicBtn6 = (Button) findViewById(R.id.BilleColle);
        findMagicBtn6.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BilleColleContent);
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

        Button findMagicBtn7 = (Button) findViewById(R.id.DunePoche);
        findMagicBtn7.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.DunePocheContent);
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

        Button findMagicBtn8 = (Button) findViewById(R.id.BLibre);
        findMagicBtn8.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BLibreContent);
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

        Button findMagicBtn9 = (Button) findViewById(R.id.FauteSnooker);
        findMagicBtn9.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.FauteSnookerContent);
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

        Button findMagicBtnA = (Button) findViewById(R.id.Penalite);
        findMagicBtnA.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PenaliteContent);
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
        Button findMagicBtnB = (Button) findViewById(R.id.BBouger);
        findMagicBtnB.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.BBougerContent);
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

        Button findMagicBtnC = (Button) findViewById(R.id.Pat);
        findMagicBtnC.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.PatContent);
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

        Button findMagicBtnD = (Button) findViewById(R.id.Jeu4);
        findMagicBtnD.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.Jeu4Content);
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
