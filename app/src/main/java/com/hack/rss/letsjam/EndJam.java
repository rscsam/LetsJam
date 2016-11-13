package com.hack.rss.letsjam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EndJam extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_jam);
    }

    public void saveJam(View v) {
        final EditText fileNameET = (EditText) findViewById(R.id.file_name_et);
        String name = fileNameET.getText().toString();
        Context context = getApplicationContext();
        File path = context.getFilesDir();
        File file = new File(path, name);
        Bundle extras = getIntent().getExtras();
        ArrayList<Integer> record = extras.getIntegerArrayList("record");
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file, false);
        } catch (java.io.FileNotFoundException e) { finish();}

        DataOutputStream dataOutput = new DataOutputStream(output);
        for(Integer integer: record) {
            try {
                dataOutput.writeInt(integer);
                Log.d("FILE", "Wrote " + integer);
            } catch (java.io.IOException e) {}
        }
        try {
            Log.d("FILE", "Wrote " + file.getCanonicalPath());
            Toast.makeText(this, "File saved to " + file.getCanonicalPath(), Toast.LENGTH_SHORT).show();
            dataOutput.flush();
            dataOutput.close();
        } catch (java.io.IOException e) {
            Log.d("FILE", "Error closing file");
        }
        Log.d("FILE", "Didn't break when writing file");
        finish();
    }

    public void returnHome(View view) {
        Intent startOver = new Intent(this, StartActivity.class);
        startActivity(startOver);
        finish();
    }
}
