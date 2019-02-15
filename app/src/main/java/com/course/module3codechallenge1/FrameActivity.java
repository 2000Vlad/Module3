package com.course.module3codechallenge1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class FrameActivity extends AppCompatActivity {

    int mScreenHeight;
    int mScreenWidth;
    int density;

    int frameWidth;
    int frameHeight;
    int margin;

    private final int LAYOUT_MARGIN=16;

    private View mView1;
    private View mView2;
    private View mView3;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_3);
        density = (int)getResources().getDisplayMetrics().density;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;


    }
    @Override
    protected void onResume()
    {
        super.onResume();
        initUi();

    }

    private void initUi() {
        mView1 = findViewById(R.id.frame_view_1);
        mView2 = findViewById(R.id.frame_view_2);
        mView3 = findViewById(R.id.frame_view_3);
        frame = findViewById(R.id.frame);

        margin=mScreenWidth/26;
        frameHeight=mScreenHeight/4;
        frameWidth=mScreenWidth-LAYOUT_MARGIN*2*density;

        int view1Width;
        int view1Height;

        int view2Width;
        int view2Height;

        int view3Width;
        int view3Height;

        view1Width=frameWidth;
        view1Height=frameHeight;

        view2Width=view1Width-2*LAYOUT_MARGIN*density;
        view2Height=view1Height/2;

        view3Width=view2Width-2*LAYOUT_MARGIN*density;
        view3Height=view2Height/2;

        mView1.getLayoutParams().width=view1Width;
        mView1.getLayoutParams().height=view1Height;

        mView2.getLayoutParams().width=view2Width;
        mView2.getLayoutParams().height=view2Height;

        mView3.getLayoutParams().width=view3Width;
        mView3.getLayoutParams().height=view3Height;

        mView1.requestLayout();
        mView2.requestLayout();
        mView3.requestLayout();
    }
}
