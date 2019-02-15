package com.course.module3codechallenge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void navigateLogin(View v)
    {
        Intent navigateIntent=new Intent(this, LoginActivity.class);
        startActivity(navigateIntent);
    }
    public void navigateScroll(View v)
    {
        Intent navigateIntent = new Intent(this, ScrollActivity.class);
        startActivity(navigateIntent);
    }
    public void navigateSpinner(View v)
    {
        Intent navigateIntent = new Intent(this,SpinnerActivity.class);
        startActivity(navigateIntent);
    }
    public void navigateFrame(View v)
    {
        Intent navigateIntent = new Intent(this,FrameActivity.class);
        startActivity(navigateIntent);
    }

}
