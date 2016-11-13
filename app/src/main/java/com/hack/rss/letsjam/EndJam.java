package com.hack.rss.letsjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class EndJam extends AppCompatActivity {

    ArrayList<Integer> record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_jam);

        Bundle extras = getIntent().getExtras();
        record = extras.getIntegerArrayList("record");
    }


    void saveJam() {
        for(Integer integer: record) {

        }
    }
}
