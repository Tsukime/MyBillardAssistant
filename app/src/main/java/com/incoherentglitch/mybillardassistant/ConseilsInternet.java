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

public class ConseilsInternet extends AppCompatActivity {

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
        setContentView(R.layout.activity_conseils_internet);


        //bouton_conseils_internet
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

        Button findMagicBtn = (Button) findViewById(R.id.hintI);
        findMagicBtn.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.hintI_content);
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

        Button findMagicBtn2 = (Button) findViewById(R.id.hintII);
        findMagicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.hintII_Content);
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

        Button findMagicBtn3 = (Button) findViewById(R.id.hintIII);
        findMagicBtn3.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.hintIII_Content);
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

        Button findMagicBtn4 = (Button) findViewById(R.id.hintIV);
        findMagicBtn4.setOnClickListener(new View.OnClickListener() {
            boolean animationClosing = false;

            @Override
            public void onClick(View v) {
                if (!animationClosing) {
                    final LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.hintIV_Content);
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
