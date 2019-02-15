package com.course.module3codechallenge1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScrollActivity extends AppCompatActivity {

    private TextView paragraph1;
    private TextView paragraph2;
    private TextView paragraph3;
    private TextView paragraph4;
    private TextView paragraph5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_2);
        initUi();
        initText();
    }

    private void initUi() {
        paragraph1 = findViewById(R.id.paragraph_1);
        paragraph2=findViewById(R.id.paragraph_2);
        paragraph3=findViewById(R.id.paragraph_3);
        paragraph4=findViewById(R.id.paragraph_4);
        paragraph5=findViewById(R.id.paragraph_5);
    }

    private void initText() {
        try {
            InputStream stream = getResources().openRawResource(R.raw.scroll_view_description);
            DataInputStream dataStream = new DataInputStream(stream);
            byte[] fullText=new byte[dataStream.available()];
            dataStream.readFully(fullText);
            String text=new String(fullText);
            paragraph1.setText(text);
            paragraph2.setText(text);
            paragraph3.setText(text);
            paragraph4.setText(text);
            paragraph5.setText(text);
        } catch (IOException e) {
            paragraph1.setText("Exception");
        }
    }


}

