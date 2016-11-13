package com.hack.rss.letsjam;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PlayPianoFragment extends Fragment implements View.OnClickListener {
    private OnPianoInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_piano, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("pls", "harambe daddy pls");
        if (activity instanceof OnPianoInteractionListener) {
            listener = (OnPianoInteractionListener) activity;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a_button:
            case R.id.a2_button:
                listener.addSound(new Note(0, R.raw.a_piano));
                Log.d("tag", "a pressed");
                break;
            case R.id.b_button:
            case R.id.b2_button:
                Log.d("tag", "b pressed");
                listener.addSound(new Note(0, R.raw.b_piano));
                break;
            case R.id.c_button:
            case R.id.c2_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.c_piano));
                break;
            case R.id.d_button:
            case R.id.d2_button:
                Log.d("tag", "d pressed");
                listener.addSound(new Note(0, R.raw.d_piano));
                break;
            case R.id.e_button:
            case R.id.e2_button:
                Log.d("tag", "e pressed");
                listener.addSound(new Note(0, R.raw.e_piano));
                break;
            case R.id.f_button:
            case R.id.f2_button:
                Log.d("tag", "f pressed");
                listener.addSound(new Note(0, R.raw.f_piano));
                break;
            case R.id.g_button:
            case R.id.g2_button:
                Log.d("tag", "g pressed");
                listener.addSound(new Note(0, R.raw.g_piano));
                break;
            case R.id.as_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.as_piano));
                break;
            case R.id.cs_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.cs_piano));
                break;
            case R.id.ds_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.ds_piano));
                break;
            case R.id.fs_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.fs_piano));
                break;
            case R.id.gs_button:
                Log.d("tag", "c pressed");
                listener.addSound(new Note(0, R.raw.gs_piano));
                break;
        }
    }

    public interface OnPianoInteractionListener {
        void onPianoInteraction(View v);
        void addSound(Note n);
    }
}
