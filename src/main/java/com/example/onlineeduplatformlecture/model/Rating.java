package com.example.onlineeduplatformlecture.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "rating")
@Getter
@Setter
@ToString
public class Rating {

    @Id
    @Column(value = "rating_id")
    Integer ratingId;

    @Column(value = "lecture_id")
    Integer lectureId;

    @Column(value = "user_id")
    Integer userId;

    @Column(value = "rating")
    Double rating;

    @Column(value = "comment")
    String comment;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    @Builder
    public Rating(Integer ratingId, Integer lectureId, Integer userId, Double rating, String comment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.ratingId = ratingId;
        this.lectureId = lectureId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
