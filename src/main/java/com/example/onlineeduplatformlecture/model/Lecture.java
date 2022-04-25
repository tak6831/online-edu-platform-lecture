package com.example.onlineeduplatformlecture.model;

public class Lecture {

    private final int lectureId;
    private int teacherId;
    private final String title;
    private int exposedYn;
    private final String location;

    public Lecture(int lecture_id, String title, String location) {
        this.lectureId = lecture_id;
        this.title = title;
        this.location = location;
        this.exposedYn = 0;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getTeacherId() {
        return teacherId;
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

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setExposedYn(int exposedYn) {
        this.exposedYn = exposedYn;
    }
}
