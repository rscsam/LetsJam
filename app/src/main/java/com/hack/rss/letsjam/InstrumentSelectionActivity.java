package com.hack.rss.letsjam;

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

    public void playSound(View view) {
        MediaPlayer.create(this, R.raw.f0_piano).start();
    }
}
