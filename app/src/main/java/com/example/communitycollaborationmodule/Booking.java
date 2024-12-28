package com.example.communitycollaborationmodule;

public class Booking {
    private String title;
    private String date;
    private String time;
    private int participants;

    public Booking(String title, String date, String time, int participants) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.participants = participants;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getParticipants() {
        return participants;
    }
}
