package com.hack.rss.letsjam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class EndJam extends AppCompatActivity {

    ArrayList<Integer> record;
    Context context = getApplicationContext();
    File path = context.getFilesDir();
    String name = "";
    File file = new File(path, name);

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
