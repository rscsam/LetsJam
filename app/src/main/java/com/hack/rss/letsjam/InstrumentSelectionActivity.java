package com.hack.rss.letsjam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

public class InstrumentSelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_selection);

        ImageButton pianoBttn = (ImageButton) findViewById(R.id.piano_ib);
        ImageButton drumsBttn = (ImageButton) findViewById(R.id.drums_ib);
        ImageButton guitarBttn = (ImageButton) findViewById(R.id.guitar_ib);
        ImageButton bassBttn = (ImageButton) findViewById(R.id.bass_ib);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int size = (int) (screenWidth * 0.2);
        pianoBttn.getLayoutParams().height = size;
        pianoBttn.getLayoutParams().width = size;
        drumsBttn.getLayoutParams().height = size;
        drumsBttn.getLayoutParams().width = size;
        guitarBttn.getLayoutParams().height = size;
        guitarBttn.getLayoutParams().width = size;
        bassBttn.getLayoutParams().height = size;
        bassBttn.getLayoutParams().width = size;
    }

    public void startJamPiano(View view) {
        Intent jamSession = new Intent(this, JamActivity.class);
        jamSession.putExtra("instrument", 0);
        startActivity(jamSession);
        finish();
    }

    public void startJamDrums(View view) {
        Intent jamSession = new Intent(this, JamActivity.class);
        jamSession.putExtra("instrument", 1);
        startActivity(jamSession);
        finish();
    }

    public void startJamGuitar(View view) {
        Intent jamSession = new Intent(this, JamActivity.class);
        jamSession.putExtra("instrument", 2);
        startActivity(jamSession);
        finish();
    }

    public void startJamBass(View view) {
        Intent jamSession = new Intent(this, JamActivity.class);
        jamSession.putExtra("instrument", 3);
        startActivity(jamSession);
        finish();
    }
}
