package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Lecture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LectureRepositoryTest {

    @Autowired
    LectureRepository lectureRepository;
    Lecture lecture;
    @BeforeEach
    void setUp() {
        this.lecture = new Lecture("이것이 강좌다","우리집");
    }
    //강의노출상태변경
    @Test
    void 강의노출상태변경(){
        lectureRepository.save(lecture);
        System.out.println("비포 >>>>>>>>>>>> ");
        System.out.println(lecture.toString());
        lecture.setExposedYn(1);
        lectureRepository.saveAndFlush(lecture);
        System.out.println("에프터 >>>>>>>>>>>> ");
        System.out.println(lecture.toString());
    }
}