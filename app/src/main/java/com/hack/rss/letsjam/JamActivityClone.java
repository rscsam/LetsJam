package com.hack.rss.letsjam;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JamActivityClone extends AppCompatActivity
        implements PlayPianoFragment.OnFragmentInteractionListener {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_jam);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        fragment = null;
        Bundle extras = getIntent().getExtras();
        int instrument = extras.getInt("instrument");
        if (instrument == 0)
            fragment = new PlayPianoFragment();
//        else if (instrument == 1)
//            fragment = new PlayDrumsFragment();
//        else if (instrument == 2)
//            fragment = new PlayGuitarFragment();
//        else if (instrument == 3)
//            fragment = new PlayBassFragment();
        else
            finish();
        ft.replace(android.R.id.content, fragment);

        ft.commit();
    }

    public void onFragmentInteraction() { }
}