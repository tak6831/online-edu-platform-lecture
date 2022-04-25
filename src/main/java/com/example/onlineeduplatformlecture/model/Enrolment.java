package com.example.onlineeduplatformlecture.model;

public class Enrolment {

    private final int enrolmentId;
    private final int lectureId;
    private final int userId;

    public Enrolment(int enrolmentId, int lectureId, int userId) {
        this.enrolmentId = enrolmentId;
        this.lectureId = lectureId;
        this.userId = userId;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getUserId() {
        return userId;
    }

}
