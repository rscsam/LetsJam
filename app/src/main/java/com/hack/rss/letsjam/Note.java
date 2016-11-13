package com.hack.rss.letsjam;


public class Note {
    private int instrument;
    private long time;
    private int soundFile;

    public Note(int instrument, long time, int soundFile) {
        this.instrument = instrument;
        this.time = time;
        this.soundFile = soundFile;
    }

    public int getInstrument() {
        return instrument;
    }

    public long getTime() {
        return time;
    }

    public int getsoundFile() {
        return soundFile;
    }


}
