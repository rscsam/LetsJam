package com.hack.rss.letsjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

public class JamActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jam);
    }

    public void playSound(View view) {
        if (System.nanoTime() % 10 == 0) {
            MediaPlayer.create(this, R.raw.f0_piano).start();
        }

    }


    public void addSound(Note note) {
        if (note.getInstrument().equals("Piano")) {

        }
    }
}
