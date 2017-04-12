package com.incoherentglitch.mybillardassistant;

import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Vector;

import static java.lang.Math.sqrt;

public class ReglesAmericain extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
        setContentView(R.layout.activity_regles_americain);

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

        Button findMagicBtn = (Button) findViewById(R.id.magic_btn_generales);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_generales);
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

        Button findMagicBtn2 = (Button) findViewById(R.id.magic_btn_generales_debut);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_generales_debut);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.magic_btn_americain_generales_fautes);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_generales_fautes);
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

        Button findMagicBtn4 = (Button) findViewById(R.id.magic_btn_jeu_8);
        findMagicBtn4.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_jeu_8);
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

        Button findMagicBtn5 = (Button) findViewById(R.id.magic_btn_8_intro);
        findMagicBtn5.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_8_intro);
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

        Button findMagicBtn6 = (Button) findViewById(R.id.magic_btn_americain_8_regles);
        findMagicBtn6.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_8_regles);
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

        Button findMagicBtn7 = (Button) findViewById(R.id.magic_btn_americain_8_fautes);
        findMagicBtn7.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_8_fautes);
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

        Button findMagicBtn8 = (Button) findViewById(R.id.magic_btn_americain_8_noire);
        findMagicBtn8.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_8_noire);
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

        Button findMagicBtn9 = (Button) findViewById(R.id.magic_btn_jeu_9);
        findMagicBtn9.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_jeu_9);
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

        Button findMagicBtn10 = (Button) findViewById(R.id.magic_btn_9_intro);
        findMagicBtn10.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_9_intro);
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

        Button findMagicBtn11 = (Button) findViewById(R.id.magic_btn_americain_9_deroulement);
        findMagicBtn11.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_9_deroulement);
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

        Button findMagicBtn12 = (Button) findViewById(R.id.magic_btn_americain_9_fautes);
        findMagicBtn12.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_9_fautes);
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

        Button findMagicBtn13 = (Button) findViewById(R.id.magic_btn_jeu_9_continu);
        findMagicBtn13.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_jeu_9_continu);
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

        Button findMagicBtn14 = (Button) findViewById(R.id.magic_btn_9_continu_intro);
        findMagicBtn14.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_9_continu_intro);
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

        Button findMagicBtn15 = (Button) findViewById(R.id.magic_btn_americain_9_continu_points);
        findMagicBtn15.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_9_continu_points);
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

        Button findMagicBtn16 = (Button) findViewById(R.id.magic_btn_americain_9_continu_fautes);
        findMagicBtn16.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_9_continu_fautes);
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

        Button findMagicBtn17 = (Button) findViewById(R.id.magic_btn_americain_9_continu_vainqueur);
        findMagicBtn17.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_9_continu_vainqueur);
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

        Button findMagicBtn18 = (Button) findViewById(R.id.magic_btn_jeu_14_1);
        findMagicBtn18.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_jeu_14_1);
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

        Button findMagicBtn19 = (Button) findViewById(R.id.magic_btn_14_but);
        findMagicBtn19.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_14_but);
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

        Button findMagicBtn20 = (Button) findViewById(R.id.magic_btn_americain_14_regles);
        findMagicBtn20.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_14_regles);
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

        Button findMagicBtn21 = (Button) findViewById(R.id.magic_btn_americain_14_deroulement);
        findMagicBtn21.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.magic_layout_americain_14_deroulement);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ReglesAmericain Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
