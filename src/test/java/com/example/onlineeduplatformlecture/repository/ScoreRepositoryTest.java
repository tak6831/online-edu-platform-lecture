package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreRepositoryTest {
    @Autowired
    ScoreRepository scoreRepository;
    private Score score;

    @BeforeEach
    void setUp() {
        this.score = new Score(1,1,"F","넌 다음에 다시보자");
    }
    //성적조회
    @Test
    void 성적조회() {
        scoreRepository.save(score);
        List<Score> result = scoreRepository.findScoreById(1,1);
        for(Score item : result){
            System.out.println(item.toString());
        }
    }
    //성적입력
    @Test
    void 성적입력() {
        scoreRepository.save(score);
    }
}