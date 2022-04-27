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
public class Content {

    @Id
    private Long contentId;
    private Long lectureId;
    private String content;
    private Long examYn;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Content(Long lectureId, String content, Long examYn) {
        this.lectureId = lectureId;
        this.content = content;
        this.examYn = examYn;
    }

}
