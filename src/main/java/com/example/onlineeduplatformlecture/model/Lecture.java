package com.example.onlineeduplatformlecture.model;

public class Lecture {

    private final int lectureId;
    private final String title;
    private final String location;
    private int exposedYn;

    public Lecture(int lecture_id, String title, String location) {
        this.lectureId = lecture_id;
        this.title = title;
        this.location = location;
        this.exposedYn = 0;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getTitle() {
        return title;
    }

    public int getExposedYn() {
        return exposedYn;
    }

    public String getLocation() {
        return location;
    }

    public void setExposedYn(int exposedYn) {
        this.exposedYn = exposedYn;
    }
}
