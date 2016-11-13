package com.hack.rss.letsjam;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;

public class JamActivity extends AppCompatActivity {
    //SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();
    SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);


    int[] sounds = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jam);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new play(), new java.util.Date(), 1000);
        try {
            File outputFile = File.createTempFile("temp", null, getCacheDir());
        } catch(java.io.IOException e) {}
    }

    /*
    public void playSound() {
        if (System.nanoTime() % 10 == 0) {
            MediaPlayer.create(this, R.raw.f0_piano).start();
            soundPool.play(piano1, 1, 1, 0, 0, 1);
        }

    }
    */


    public void addSound(Note note) {

        switch(note.getInstrument()) {
            case 0:
                if (sounds[0] == 0) {
                    sounds[0] = note.getsoundFile();
                } else if (sounds[1] == 0){
                    sounds[1] = note.getsoundFile();
                }
                break;
            case 1:
                if (sounds[2] == 0) {
                    sounds[2] = note.getsoundFile();
                } else if (sounds[3] == 0){
                    sounds[3] = note.getsoundFile();
                }
                break;
            case 2:
                if (sounds[4] == 0) {
                    sounds[4] = note.getsoundFile();
                }
                break;
            case 3:
                if (sounds[5] == 0) {
                    sounds[5] = note.getsoundFile();
                }
                break;


        }
    }

    class play extends TimerTask {
        @Override
        public void run() {

            for(int i = 0; i < 6; i++) {
                if (sounds[i] != 0) {
                    soundPool.play(sounds[i], 1, 1, 0, 0, 1);
                    sounds[i] = 0;
                }
            }
        }
    }
}
