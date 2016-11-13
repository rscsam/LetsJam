package com.hack.rss.letsjam;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PlayGuitarFragment extends Fragment implements View.OnClickListener {
    private OnGuitarInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_guitar, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnGuitarInteractionListener) {
            listener = (OnGuitarInteractionListener) activity;
        } else {
            Log.d("pls", "harambe daddy pls");
            throw new ClassCastException();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.amaj_button:
                listener.addSound(new Note(2, R.raw.amaj_guitar));
                break;
            case R.id.asmaj_button:
                listener.addSound(new Note(2, R.raw.asmaj_guitar));
                break;
            case R.id.bmaj_button:
                listener.addSound(new Note(2, R.raw.bmaj_guitar));
                break;
            case R.id.cmaj_button:
                listener.addSound(new Note(2, R.raw.cmaj_guitar));
                break;
            case R.id.csmaj_button:
                listener.addSound(new Note(2, R.raw.csmaj_guitar));
                break;
            case R.id.dmaj_button:
                listener.addSound(new Note(2, R.raw.dmaj_guitar));
                break;
            case R.id.dsmaj_button:
                listener.addSound(new Note(2, R.raw.dsmaj_guitar));
                break;
            case R.id.emaj_button:
                listener.addSound(new Note(2, R.raw.emaj_guitar));
                break;
            case R.id.fmaj_button:
                listener.addSound(new Note(2, R.raw.fmaj_guitar));
                break;
            case R.id.fsmaj_button:
                listener.addSound(new Note(2, R.raw.fsmaj_guitar));
                break;
            case R.id.gmaj_button:
                listener.addSound(new Note(2, R.raw.gmaj_guitar));
                break;
            case R.id.gsmaj_button:
                listener.addSound(new Note(2, R.raw.gsmaj_guitar));
                break;
            case R.id.amin_button:
                listener.addSound(new Note(2, R.raw.amin_guitar));
                break;
            case R.id.asmin_button:
                listener.addSound(new Note(2, R.raw.asmin_guitar));
                break;
            case R.id.bmin_button:
                listener.addSound(new Note(2, R.raw.bmin_guitar));
                break;
            case R.id.cmin_button:
                listener.addSound(new Note(2, R.raw.cmin_guitar));
                break;
            case R.id.csmin_button:
                listener.addSound(new Note(2, R.raw.csmin_guitar));
                break;
            case R.id.dmin_button:
                listener.addSound(new Note(2, R.raw.dmin_guitar));
                break;
            case R.id.dsmin_button:
                listener.addSound(new Note(2, R.raw.dsmin_guitar));
                break;
            case R.id.emin_button:
                listener.addSound(new Note(2, R.raw.emin_guitar));
                break;
            case R.id.fmin_button:
                listener.addSound(new Note(2, R.raw.fmin_guitar));
                break;
            case R.id.fsmin_button:
                listener.addSound(new Note(2, R.raw.fsmin_guitar));
                break;
            case R.id.gmin_button:
                listener.addSound(new Note(2, R.raw.gmin_guitar));
                break;
            case R.id.gsmin_button:
                listener.addSound(new Note(2, R.raw.gsmin_guitar));
                break;
        }
    }

    public interface OnGuitarInteractionListener {
        void onGuitarInteraction(View v);
        void addSound(Note n);
    }
}
