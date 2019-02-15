package com.course.module3codechallenge1;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_4);
        mSpinner=findViewById(R.id.version_spinner);
        mSpinner.setAdapter(getAdapter());
        mSpinner.setOnItemSelectedListener(getListener());
    }

    private List<String> getVersions()
    {
        ArrayList<String> list=new ArrayList<>();
        list.add("Cupcake");
        list.add("Donut");
        list.add("Eclair");
        list.add("KitKat");
        list.add("Pie");
        return list;
    }
    private ArrayAdapter<String> getAdapter()
    {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getVersions());
        return adapter;
    }
    private AdapterView.OnItemSelectedListener getListener()
    {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String version=(String)parent.getSelectedItem();
                Toast.makeText(getApplicationContext(),"Selected "+version,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }
}
