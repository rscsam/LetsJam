package com.hack.rss.letsjam;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlayBassFragment extends Fragment implements View.OnClickListener {
    private OnBassInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_bass, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnBassInteractionListener) {
            listener = (OnBassInteractionListener) activity;
        } else {
            Log.d("pls", "harambe daddy pls");
            throw new ClassCastException();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ab_button:
                listener.addSound(new Note(3, R.raw.a_bass));
                break;
            case R.id.asb_button:
                listener.addSound(new Note(3, R.raw.as_bass));
                break;
            case R.id.bb_button:
                listener.addSound(new Note(3, R.raw.b_bass));
                break;
            case R.id.cb_button:
                listener.addSound(new Note(3, R.raw.c_bass));
                break;
            case R.id.csb_button:
                listener.addSound(new Note(3, R.raw.cs_bass));
                break;
            case R.id.db_button:
                listener.addSound(new Note(3, R.raw.d_bass));
                break;
            case R.id.dsb_button:
                listener.addSound(new Note(3, R.raw.ds_bass));
                break;
            case R.id.eb_button:
                listener.addSound(new Note(3, R.raw.e_bass));
                break;
            case R.id.fb_button:
                listener.addSound(new Note(3, R.raw.f_bass));
                break;
            case R.id.fsb_button:
                listener.addSound(new Note(3, R.raw.fs_bass));
                break;
            case R.id.gb_button:
                listener.addSound(new Note(3, R.raw.g_bass));
                break;
            case R.id.gsb_button:
                listener.addSound(new Note(3, R.raw.gs_bass));
                break;
        }
    }

    public interface OnBassInteractionListener {
        void onBassInteraction(View v);
        void addSound(Note n);
    }
}
