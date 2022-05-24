package com.example.onlineeduplatformlecture.model;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Lecture {

    @Id
    private Long lectureId;

    private String title;

    private String location;

    private int exposedYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Lecture(Long lectureId, String title, String location, long exposedYn, LocalDateTime now, LocalDateTime now1) {
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
