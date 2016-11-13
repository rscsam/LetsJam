package com.hack.rss.letsjam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EndJam extends AppCompatActivity {

    //// TODO: 11/13/16 Something in these declarations breaks the whole program
    /*ArrayList<Integer> record;
    Context context = getApplicationContext();
    File path = context.getFilesDir();
    String name;
    File file = new File(path, name);
    DataOutputStream dataOutput;

    EditText input;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_jam);

        //Bundle extras = getIntent().getExtras();
        /*record = extras.getIntegerArrayList("record");
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(path);
        } catch (java.io.FileNotFoundException e) { finish();}

        dataOutput = new DataOutputStream(output);*/
    }


    /*void saveJam() {

        for(Integer integer: record) {
            try {
                dataOutput.write(integer);
            } catch (java.io.IOException e) {}

        }
    }*/
}
