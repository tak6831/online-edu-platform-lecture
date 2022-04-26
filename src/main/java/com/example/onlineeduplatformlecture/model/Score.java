package com.example.onlineeduplatformlecture.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name="SCORE")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SCORE_ID")
    private int scoreId;
    @Column(name="LECTURE_ID")
    private int lectureId;
    @Column(name="USER_ID")
    private int userId;
    @Column(name="SCORE")
    private String score;
    @Column(name="COMMENT")
    private String comment;
    @Column(name="CREATE_AT")
    private String createAt;
    @Column(name="UPDATED_AT")
    private String updatedAt;

    public Score() {

    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Score(int lectureId, int userId, String score, String comment) {
        this.lectureId = lectureId;
        this.userId = userId;
        this.score = score;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", lectureId=" + lectureId +
                ", userId=" + userId +
                ", score='" + score + '\'' +
                ", comment='" + comment + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
