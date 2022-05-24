package com.example.onlineeduplatformlecture.service.impl;

import com.example.onlineeduplatformlecture.dto.RatingAverageDto;
import com.example.onlineeduplatformlecture.dto.RatingDto;
import com.example.onlineeduplatformlecture.dto.RatingSaveDto;
import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import com.example.onlineeduplatformlecture.service.RatingService;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RatingServiceImpl implements RatingService {

    private static final String TOPIC = "rating";

    private final KafkaTemplate<String, Rating> ratingKafkaTemplate;
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, KafkaTemplate kafkaTemplate) {
        this.ratingRepository = ratingRepository;
        this.ratingKafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<RatingAverageDto> getAverageRate(Flux<RatingDto> ratings) {
        return ratings.collect(Collectors.averagingDouble(RatingDto::getRating))
                .map(RatingAverageDto::new);
    }

    @Override
    public Flux<RatingDto> getRatings(Long lectureId) {
        return ratingRepository.findByLectureId(lectureId)
                .map(r -> new RatingDto(r.getRatingId(), r.getUserId(), r.getRating(), r.getComment()));
    }

    @Override
    public Mono<RatingDto> getRating(Long ratingId) {
        return ratingRepository.findById(ratingId)
                .map(r -> new RatingDto(r.getRatingId(), r.getUserId(), r.getRating(), r.getComment()));
    }

    @Override
    public Mono<Rating> getRatingByUserIdAndLectureId(Long userId, Long lectureId) {
        return ratingRepository.findByUserIdAndLectureId(userId, lectureId);
    }

    @Override
    public Mono<RatingSaveDto> saveRate(Rating rating) {
        return ratingRepository.save(rating)
                .map(r -> {
                    sendMessage(r);
                    return new RatingSaveDto(r.getRatingId());
                });
    }

    private void sendMessage(Rating rating) {
        log.info(String.format("#### -> Producing message -> %s", rating.toString()));
        this.ratingKafkaTemplate.send(TOPIC, rating);
    }


//    @KafkaListener(topics = TOPIC, groupId = "rating", containerFactory = "greetingKafkaListenerContainerFactory")
//    public void consume(Rating rating) {
//        System.out.printf("Consumed message : %s%n", rating.getRatingId());
//    }
}
