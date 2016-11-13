package com.hack.rss.letsjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selections);

        ListView fileList = (ListView) findViewById(R.id.fileList);

        List<String> files = new ArrayList<>();
        files.addAll(Arrays.asList(getApplicationContext().fileList()));
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, files
        );

        fileList.setAdapter(listAdapter);

        fileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getItemAtPosition(position);
                Log.d("FILE", "Selected item " + o.toString());
                ArrayList<Integer> notes = getNotesFromFile(o.toString());
                startInstrumentSelection(notes);
            }
        });
    }

    private void startInstrumentSelection(ArrayList<Integer> notes) {
        Intent startIS = new Intent(this, InstrumentSelectionActivity.class);
        startIS.putExtra("notes", notes);
        startActivity(startIS);
        finish();
    }

    private ArrayList<Integer> getNotesFromFile(String fileName) {
        ArrayList<Integer> notes = new ArrayList<>();
        try {
            FileInputStream input = getApplication().openFileInput(fileName);
            DataInputStream dataInput = new DataInputStream(input);
            while (dataInput.available() > 0) {
                notes.add(dataInput.readInt());
            }
        } catch (IOException e) {
            Log.d("OPEN", "Failed to open file " + fileName);
        }

        return notes;
    }
}
