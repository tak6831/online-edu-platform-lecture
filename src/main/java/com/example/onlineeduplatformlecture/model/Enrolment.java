package com.example.onlineeduplatformlecture.model;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Enrolment {

    @Id
    private  int enrolment_id;
    private  int lectureId;

    private  int userId;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Enrolment(int lectureId, int enrolmentId, int userId) {
        this.lectureId = lectureId;
        this.enrolment_id = enrolmentId;
        this.userId = userId;
    }
}
