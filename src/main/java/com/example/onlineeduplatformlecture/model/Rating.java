package com.example.onlineeduplatformlecture.model;

public class Rating {

    private final int ratingId;
    private final int lectureId;
    private final int userId;
    private final float rating;
    private final String comment;

    public Rating(int ratingId, int lectureId, int userId, float rating, String comment) {
        this.ratingId = ratingId;
        this.lectureId = lectureId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getUserId() {
        return userId;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

}
