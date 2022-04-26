package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Rating;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

public interface RatingRepository extends ReactiveCrudRepository<Rating, Long> {

//    @Query("SELECT r.rating_id, r.user_id, r.rating, r.comment, r.created_at, r.updated_at FROM RATING r WHERE r.lecture_id = :lectureId AND r.rating_id = :ratingId")
//    Mono<Rating> findRatingById(Long lectureId, Long ratingId);
}
