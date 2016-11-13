package com.hack.rss.letsjam;


public class Note {
    private String instrument;
    private long time;
    private int note;

    public Note(String instrument, long time, int note) {
        this.instrument = instrument;
        this.time = time;
        this.note = note;
    }

    public String getInstrument() {
        return instrument;
    }

    public long getTime() {
        return time;
    }

    public int getNote() {
        return note;
    }


}
