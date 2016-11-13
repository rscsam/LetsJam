package com.hack.rss.letsjam;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;



public class JamActivity extends AppCompatActivity {
    //SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();
    SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    ArrayList<Integer> record = new ArrayList<Integer>();
    Context context;

    int[] sounds = new int[6];
    HashMap<Integer, Integer> soundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jam);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new play(), new java.util.Date(), 50);
        context = getApplicationContext();

        soundMap = new HashMap<>();
        soundMap.put(R.raw.a_piano, soundPool.load(context, R.raw.a_piano, 1));
        soundMap.put(R.raw.as_piano, soundPool.load(context, R.raw.as_piano, 1));
        soundMap.put(R.raw.b_piano, soundPool.load(context, R.raw.b_piano, 1));
        soundMap.put(R.raw.c_piano, soundPool.load(context, R.raw.c_piano, 1));
        soundMap.put(R.raw.cs_piano, soundPool.load(context, R.raw.cs_piano, 1));
        soundMap.put(R.raw.d_piano, soundPool.load(context, R.raw.d_piano, 1));
        soundMap.put(R.raw.ds_piano, soundPool.load(context, R.raw.ds_piano, 1));
        soundMap.put(R.raw.e_piano, soundPool.load(context, R.raw.e_piano, 1));
        soundMap.put(R.raw.f_piano, soundPool.load(context, R.raw.f_piano, 1));
        soundMap.put(R.raw.fs_piano, soundPool.load(context, R.raw.fs_piano, 1));
        soundMap.put(R.raw.g_piano, soundPool.load(context, R.raw.g_piano, 1));
        soundMap.put(R.raw.gs_piano, soundPool.load(context, R.raw.gs_piano, 1));
    }

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

    public void endJam(View view) {
        Intent endJam = new Intent(this, EndJam.class);
        endJam.putExtra("record", record);
        startActivity(endJam);
        finish();
    }

    public void play(View view) {
        addSound(new Note(0, R.raw.a_piano));
        addSound(new Note(0, R.raw.b_piano));
    }

    class play extends TimerTask {
        @Override
        public void run() {

            for(int i = 0; i < 6; i++) {
                if (sounds[i] != 0) {
                    int sound = soundPool.load(context, sounds[i], 1);
                    soundPool.play(soundMap.get(sounds[i]), 1, 1, 0, 0, 1);
                    sounds[i] = 0;
                }
                record.add(sounds[i]);
            }

        }


    }
}
