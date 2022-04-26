package com.example.onlineeduplatformlecture.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "RATING")
@Getter
@Setter
@AllArgsConstructor
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

    @Column(value = "lecture_id")
    String comment;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

}
