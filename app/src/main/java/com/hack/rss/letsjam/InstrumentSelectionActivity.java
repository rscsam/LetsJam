package com.hack.rss.letsjam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstrumentSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_selection);
    }

    public void startJamPiano(View view) {
        Intent jamSession = new Intent(this, JamActivityClone.class);
        jamSession.putExtra("instrument", 0);
        startActivity(jamSession);
        finish();
    }

    public void startJamDrums(View view) {
        Intent jamSession = new Intent(this, JamActivityClone.class);
        jamSession.putExtra("instrument", 1);
        startActivity(jamSession);
        finish();
    }

    public void startJamGuitar(View view) {
        Intent jamSession = new Intent(this, JamActivityClone.class);
        jamSession.putExtra("instrument", 2);
        startActivity(jamSession);
        finish();
    }

    public void startJamBass(View view) {
        Intent jamSession = new Intent(this, JamActivityClone.class);
        jamSession.putExtra("instrument", 3);
        startActivity(jamSession);
        finish();
    }
}
