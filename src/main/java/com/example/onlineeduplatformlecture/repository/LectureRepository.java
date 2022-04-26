package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
