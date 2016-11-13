package com.hack.rss.letsjam;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlayDrumsFragment extends Fragment implements View.OnClickListener {
    private OnDrumsInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_drums, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnDrumsInteractionListener) {
            listener = (OnDrumsInteractionListener) activity;
        } else {
            Log.d("pls", "harambe daddy pls");
            throw new ClassCastException();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.snare_button:
                listener.addSound(new Note(1, R.raw.snare));
                break;
            case R.id.kick_button:
                listener.addSound(new Note(1, R.raw.kick));
                break;
            case R.id.crash_button:
                listener.addSound(new Note(1, R.raw.crash));
                break;
            case R.id.hihat_button:
                listener.addSound(new Note(1, R.raw.hihat));
                break;
        }
    }

    public interface OnDrumsInteractionListener {
        void onDrumsInteraction(View v);
        void addSound(Note n);
    }
}
