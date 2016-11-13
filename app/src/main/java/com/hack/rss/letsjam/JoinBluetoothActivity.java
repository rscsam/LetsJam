package com.hack.rss.letsjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JoinBluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_bluetooth);
    }

    public void startJamSession(View view) {
        Intent joinBluetoothActivity = new Intent(this, InstrumentSelectionActivity.class);
        startActivity(joinBluetoothActivity);
    }
}
