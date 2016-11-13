package com.hack.rss.letsjam;


public class Note {
    private int instrument;
    private long time;
    private int soundFile;

    public Note(int instrument, int soundFile) {
        this.instrument = instrument;
        this.time = time;
        this.soundFile = soundFile;
    }

    public int getInstrument() {
        return instrument;
    }


    public int getsoundFile() {
        return soundFile;
    }


}
