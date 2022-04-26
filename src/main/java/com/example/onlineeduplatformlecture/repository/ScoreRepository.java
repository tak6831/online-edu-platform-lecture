package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("select s from Score s where s.lectureId = :lectureId and s.userId = :userId")
    List<Score> findScoreById(int lectureId, int userId);


}
