package com.hack.rss.letsjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selections);
    }

    public void startJamActivity(View view) {
        Intent joinBluetoothActivity = new Intent(this, InstrumentSelectionActivity.class);
        startActivity(joinBluetoothActivity);
        finish();
    }
}
