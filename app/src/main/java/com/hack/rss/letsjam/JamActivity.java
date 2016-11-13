package com.hack.rss.letsjam;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class JamActivity extends AppCompatActivity
        implements PlayPianoFragment.OnPianoInteractionListener,
        PlayGuitarFragment.OnGuitarInteractionListener,
        PlayBassFragment.OnBassInteractionListener,
        PlayDrumsFragment.OnDrumsInteractionListener {
    //SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();
    SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    ArrayList<Integer> record = new ArrayList<>();
    Context context;

    int[] sounds = new int[6];
    HashMap<Integer, Integer> soundMap;
    ArrayList<Integer> playback = new ArrayList<>();
    int counter = 0;

    Fragment fragment;

    Timer timer;
    int clock;
    int clockRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        fragment = null;
        Bundle extras = getIntent().getExtras();
        int instrument = extras.getInt("instrument");
        playback = extras.getIntegerArrayList("notes");
        if (instrument == 0)
            fragment = new PlayPianoFragment();
        else if (instrument == 1)
            fragment = new PlayDrumsFragment();
        else if (instrument == 2)
            fragment = new PlayGuitarFragment();
        else if (instrument == 3)
            fragment = new PlayBassFragment();
        else
            finish();
        ft.replace(android.R.id.content, fragment);

        ft.commit();

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

        soundMap.put(R.raw.amaj_guitar, soundPool.load(context, R.raw.amaj_guitar, 1));
        soundMap.put(R.raw.asmaj_guitar, soundPool.load(context, R.raw.asmaj_guitar, 1));
        soundMap.put(R.raw.bmaj_guitar, soundPool.load(context, R.raw.bmaj_guitar, 1));
        soundMap.put(R.raw.cmaj_guitar, soundPool.load(context, R.raw.cmaj_guitar, 1));
        soundMap.put(R.raw.csmaj_guitar, soundPool.load(context, R.raw.csmaj_guitar, 1));
        soundMap.put(R.raw.dmaj_guitar, soundPool.load(context, R.raw.dmaj_guitar, 1));
        soundMap.put(R.raw.dsmaj_guitar, soundPool.load(context, R.raw.dsmaj_guitar, 1));
        soundMap.put(R.raw.emaj_guitar, soundPool.load(context, R.raw.emaj_guitar, 1));
        soundMap.put(R.raw.fmaj_guitar, soundPool.load(context, R.raw.fmaj_guitar, 1));
        soundMap.put(R.raw.fsmaj_guitar, soundPool.load(context, R.raw.fsmaj_guitar, 1));
        soundMap.put(R.raw.gmaj_guitar, soundPool.load(context, R.raw.gmaj_guitar, 1));
        soundMap.put(R.raw.gsmaj_guitar, soundPool.load(context, R.raw.gsmaj_guitar, 1));
        soundMap.put(R.raw.amin_guitar, soundPool.load(context, R.raw.amin_guitar, 1));
        soundMap.put(R.raw.asmin_guitar, soundPool.load(context, R.raw.asmin_guitar, 1));
        soundMap.put(R.raw.bmin_guitar, soundPool.load(context, R.raw.bmin_guitar, 1));
        soundMap.put(R.raw.cmin_guitar, soundPool.load(context, R.raw.cmin_guitar, 1));
        soundMap.put(R.raw.csmin_guitar, soundPool.load(context, R.raw.csmin_guitar, 1));
        soundMap.put(R.raw.dmin_guitar, soundPool.load(context, R.raw.dmin_guitar, 1));
        soundMap.put(R.raw.dsmin_guitar, soundPool.load(context, R.raw.dsmin_guitar, 1));
        soundMap.put(R.raw.emin_guitar, soundPool.load(context, R.raw.emin_guitar, 1));
        soundMap.put(R.raw.fmin_guitar, soundPool.load(context, R.raw.fmin_guitar, 1));
        soundMap.put(R.raw.fsmin_guitar, soundPool.load(context, R.raw.fsmin_guitar, 1));
        soundMap.put(R.raw.gmin_guitar, soundPool.load(context, R.raw.gmin_guitar, 1));
        soundMap.put(R.raw.gsmin_guitar, soundPool.load(context, R.raw.gsmin_guitar, 1));

        soundMap.put(R.raw.a_bass, soundPool.load(context, R.raw.a_bass, 1));
        soundMap.put(R.raw.as_bass, soundPool.load(context, R.raw.as_bass, 1));
        soundMap.put(R.raw.b_bass, soundPool.load(context, R.raw.b_bass, 1));
        soundMap.put(R.raw.c_bass, soundPool.load(context, R.raw.c_bass, 1));
        soundMap.put(R.raw.cs_bass, soundPool.load(context, R.raw.cs_bass, 1));
        soundMap.put(R.raw.d_bass, soundPool.load(context, R.raw.d_bass, 1));
        soundMap.put(R.raw.ds_bass, soundPool.load(context, R.raw.ds_bass, 1));
        soundMap.put(R.raw.e_bass, soundPool.load(context, R.raw.e_bass, 1));
        soundMap.put(R.raw.f_bass, soundPool.load(context, R.raw.f_bass, 1));
        soundMap.put(R.raw.fs_bass, soundPool.load(context, R.raw.fs_bass, 1));
        soundMap.put(R.raw.g_bass, soundPool.load(context, R.raw.g_bass, 1));
        soundMap.put(R.raw.gs_bass, soundPool.load(context, R.raw.gs_bass, 1));

        soundMap.put(R.raw.kick, soundPool.load(context, R.raw.kick, 1));
        soundMap.put(R.raw.snare, soundPool.load(context, R.raw.snare, 1));
        soundMap.put(R.raw.crash, soundPool.load(context, R.raw.crash, 1));
        soundMap.put(R.raw.hihat, soundPool.load(context, R.raw.hihat, 1));

        clockRate = 50;
        timer = new Timer();
        timer.scheduleAtFixedRate(new play(), new java.util.Date(), clockRate);

        clock = 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
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

    public void onPianoInteraction(View v) {
        Log.d("Fragstart", "Launch piano");
        ((PlayPianoFragment) fragment).onClick(v);
    }
    public void onDrumsInteraction(View v) {
        Log.d("Fragstart", "Launch drums");
        ((PlayDrumsFragment) fragment).onClick(v);
    }

    public void onGuitarInteraction(View v) {
        Log.d("Fragstart", "Launch guitar");
        ((PlayGuitarFragment) fragment).onClick(v);
    }

    public void onBassInteraction(View v) {
        Log.d("Fragstart", "Launch bass");
        ((PlayBassFragment) fragment).onClick(v);
    }

    class play extends TimerTask {
        @Override
        public void run() {
            clock += clockRate;
            for(int i = 0; i < 6; i++) {
                if (sounds[i] != 0) {
                    soundPool.play(soundMap.get(sounds[i]), 1, 1, 0, 0, 1);
                    counter++;
                    record.add(sounds[i]);
                } else {
                    if (playback.size() > 0 && playback.get(counter) != null && playback.get(counter) != 0) {
                        soundPool.play(soundMap.get(playback.get(counter)), 1, 1, 0, 0, 1);
                        record.add(playback.get(counter));
                    } else {
                        record.add(0);
                    }
                    counter++;
                }

                sounds[i] = 0;
            }
            if (clock > 30000) {
                Log.d("Fin", "Clock finished");
                this.cancel();
                Log.d("Fin", "Timer canceled");
                endJam(null);
                Log.d("Fin", "ERROR: still going");
            }
        }
    }
}
