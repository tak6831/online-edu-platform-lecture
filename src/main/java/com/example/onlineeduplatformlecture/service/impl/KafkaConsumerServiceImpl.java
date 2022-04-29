package com.example.onlineeduplatformlecture.service.impl;

import com.example.onlineeduplatformlecture.model.Lecture;
import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.LectureRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class KafkaConsumerServiceImpl {

    private static final String TOPIC = "rating";

    private final LectureRepository lectureRepository;

    public KafkaConsumerServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @KafkaListener(topics = TOPIC, groupId = "rating", containerFactory = "ratingKafkaListenerContainerFactory")
    public void consume(Rating rating) {
        Mono<Lecture> lectureMono = lectureRepository.findById(rating.getLectureId());

        System.out.printf("[Event] '%s' 강의의 새로운 별점이 등록되었습니다!(ratingId : %s)%n", lectureMono.block().getTitle(), rating.getRatingId());
    }
}
