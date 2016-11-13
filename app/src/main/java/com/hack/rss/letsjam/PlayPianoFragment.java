package com.hack.rss.letsjam;

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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment_play_piano, container, false);
        Button ab = (Button) view.findViewById(R.id.a_button);
        ab.setOnClickListener(this);
        Button bb = (Button) view.findViewById(R.id.b_button);
        bb.setOnClickListener(this);
        Button cb = (Button) view.findViewById(R.id.c_button);
        cb.setOnClickListener(this);
        Button db = (Button) view.findViewById(R.id.d_button);
        db.setOnClickListener(this);
        Button eb = (Button) view.findViewById(R.id.e_button);
        eb.setOnClickListener(this);
        Button fb = (Button) view.findViewById(R.id.f_button);
        fb.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a_button:
                ((JamActivity) getActivity()).addSound(new Note(0, R.raw.a_piano));
                Log.d("tag", "a pressed");
                break;
            case R.id.b_button:
                Log.d("tag", "b pressed");
                break;
            case R.id.c_button:
                Log.d("tag", "c pressed");
                break;
            case R.id.d_button:
                Log.d("tag", "d pressed");
                break;
            case R.id.e_button:
                Log.d("tag", "e pressed");
                break;
            case R.id.f_button:
                Log.d("tag", "f pressed");
                ((JamActivity) getActivity()).addSound(new Note(0, R.raw.f_piano));
                break;
        }
    }

    public interface OnPianoInteractionListener {
        void onPianoInteraction();
    }
}
