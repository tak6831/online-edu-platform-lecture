package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Content;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ContentRepository extends ReactiveCrudRepository<Content, Long> {
/*
    Flux<Content> findContentByLectureId(long lectuerId);
    Mono<Content> findByLectureIdAndContentId(long lectuerId, long contentId);*/

    Flux<Content> findByLectureId(long lectureId);
    Mono<Content> findByLectureIdAndContentId(long lectuerId, long contentId);
}
