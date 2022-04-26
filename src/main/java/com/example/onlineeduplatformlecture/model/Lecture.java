package com.example.onlineeduplatformlecture.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="LECTURE")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LECTURE_ID ")
    private int lectureId;
    @Column(name="TITLE")
    private String title;
    @Column(name="LOCATION")
    private String location;
    @Column(name="EXPOSED_YN")
    private int exposedYn;

    public Lecture() {

    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getExposedYn() {
        return exposedYn;
    }

    public void setExposedYn(int exposedYn) {
        this.exposedYn = exposedYn;
    }

    public Lecture(String title, String location) {
        this.title = title;
        this.location = location;
        this.exposedYn = 0;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", exposedYn=" + exposedYn +
                '}';
    }
}
