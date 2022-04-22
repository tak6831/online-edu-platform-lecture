package com.example.onlineeduplatformlecture.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public interface LectureHandler {

    Mono<ServerResponse> getLectureList(ServerRequest serverRequest);

    Mono<ServerResponse> getLecture(ServerRequest serverRequest);

    Mono<ServerResponse> changeExposeLecture(ServerRequest serverRequest);

    Mono<ServerResponse> enroleLecture(ServerRequest serverRequest);

    Mono<ServerResponse> matchTeacher(ServerRequest serverRequest);

    Mono<ServerResponse> getContentList(ServerRequest serverRequest);

    Mono<ServerResponse> uploadContent(ServerRequest serverRequest);

    Mono<ServerResponse> getContent(ServerRequest serverRequest);

    Mono<ServerResponse> getScore(ServerRequest serverRequest);

    Mono<ServerResponse> setScore(ServerRequest serverRequest);

    Mono<ServerResponse> getRatingList(ServerRequest serverRequest);

    Mono<ServerResponse> getRating(ServerRequest serverRequest);

    Mono<ServerResponse> setRating(ServerRequest serverRequest);

}
