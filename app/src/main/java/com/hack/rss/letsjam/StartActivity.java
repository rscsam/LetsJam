package com.hack.rss.letsjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startHostBluetoothActivity(View view) {
        Intent hostBluetoothActivity = new Intent(this, HostBluetoothActivity.class);
        startActivity(hostBluetoothActivity);
    }

    public void startJoinBluetoothActivity(View view) {
        Intent joinBluetoothActivity = new Intent(this, JoinBluetoothActivity.class);
        startActivity(joinBluetoothActivity);
    }
}
