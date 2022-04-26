package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import com.example.onlineeduplatformlecture.service.RatingService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class RatingHandler {

    private final RatingRepository ratingRepository;
    private final RatingService ratingService;

    public RatingHandler(
            RatingRepository ratingRepository,
            RatingService ratingService) {
        this.ratingRepository = ratingRepository;
        this.ratingService = ratingService;
    }

    public Mono<ServerResponse> getRatingList(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> getRating(ServerRequest request) {

        String lectureId = request.pathVariable("lectureId");
        String ratingId = request.pathVariable("ratingId");

        if ((!lectureId.isBlank()) && (!ratingId.isBlank())) {

            Mono<Rating> ratingMono = ratingRepository
                    .findRatingById(Integer.valueOf(lectureId), Integer.valueOf(ratingId))
                    .log();

            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(ratingMono, Rating.class);
        }

        return ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> saveRating(ServerRequest request) {

//        Mono<Rating> ratingMono = request.bodyToMono(Rating.class)
//            .flatMap(ratingService::saveRate)
//                .log(">>>> saveRating Service: ");
//
//        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(ratingMono, Rating.class)
//                .log(">>> saveRating Response: ")
//                .onErrorResume(error -> ServerResponse.badRequest().build());

        return null;
    }
}
