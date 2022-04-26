package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import com.example.onlineeduplatformlecture.service.RatingService;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
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
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        int lectureId = Integer.parseInt(request.pathVariable("lectureId"));

        Flux<Rating> ratings = this.ratingRepository.findAll();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(ratings, Rating.class);

//        return Mono.just(ratingRepository.findById(lectureId))
//                .flatMap(rating -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(rating), Rating.class).switchIfEmpty(notFound));

//        return ServerResponse
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(ratingMono, Rating.class)
//                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> getRating(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        int lectureId = Integer.parseInt(request.pathVariable("lectureId"));
        int ratingId = Integer.parseInt(request.pathVariable("ratingId"));

        Mono<Rating> ratingMono = ratingRepository
                .findRatingById(lectureId, ratingId)
                .log();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ratingMono, Rating.class)
                .switchIfEmpty(notFound);
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
