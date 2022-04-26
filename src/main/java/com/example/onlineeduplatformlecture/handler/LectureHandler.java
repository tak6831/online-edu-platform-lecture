package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;

@Component
public class LectureHandler {

    @Autowired
    RatingService ratingService;

//    Mono<ServerResponse> getLectureList(ServerRequest serverRequest);
//    Mono<ServerResponse> getLecture(ServerRequest serverRequest);
//    Mono<ServerResponse> createLecture(ServerRequest serverRequest);
//    Mono<ServerResponse> changeExposeLecture(ServerRequest serverRequest);
//
//    Mono<ServerResponse> enrollLecture(ServerRequest serverRequest);
//
//    Mono<ServerResponse> matchTeacher(ServerRequest serverRequest);
//
//    Mono<ServerResponse> getContentList(ServerRequest serverRequest);
//    Mono<ServerResponse> uploadContent(ServerRequest serverRequest);
//    Mono<ServerResponse> getContent(ServerRequest serverRequest);
//
//    Mono<ServerResponse> getScore(ServerRequest serverRequest);
//    Mono<ServerResponse> setScore(ServerRequest serverRequest);

//    public Mono<ServerResponse> getRatingList(ServerRequest serverRequest){
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(fromObject(ratingService.getRatingList()));
//    };
//
//    public Mono<ServerResponse> getRating(ServerRequest serverRequest){
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(ratingService.getRating());
//    };
//    public Mono<ServerResponse> setRating(ServerRequest serverRequest){
//        Rating rating = serverRequest.bodyToMono(Rating.class).block();
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(ratingService.saveRating(rating));
//    };

}
