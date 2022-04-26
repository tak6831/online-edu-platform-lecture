package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Rating;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RatingRepository extends ReactiveSortingRepository<Rating, Integer> {

    @Query("SELECT * FROM RATING WHERE lecture_id = $1 AND rating_id = $2")
    Mono<Rating> findRatingById(Integer lectureId, Integer ratingId);
}
