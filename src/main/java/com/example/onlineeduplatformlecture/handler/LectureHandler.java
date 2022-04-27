package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Content;
import com.example.onlineeduplatformlecture.model.Lecture;
import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.model.Score;
import com.example.onlineeduplatformlecture.repository.LectureRepository;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import com.example.onlineeduplatformlecture.repository.ScoreRepository;
import com.example.onlineeduplatformlecture.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;

@Component
public class LectureHandler {

    private final LectureService lectureService;
    private final EnrolmentService enrolmentService;
    private final ContentService contentService;
    private final ScoreService scoreService;
    public LectureHandler(
            LectureService lectureService,
            EnrolmentService enrolmentService,
            ContentService contentService,
            ScoreService scoreService) {
        this.lectureService = lectureService;
        this.enrolmentService = enrolmentService;
        this.contentService = contentService;
        this.scoreService = scoreService;

    }

    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    LectureRepository lectureRepository;
    public Mono<ServerResponse> getLectureList(ServerRequest serverRequest){
        Flux<Lecture> lectureList = lectureService.getLectureList();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureList, Lecture.class);
    }
    public Mono<ServerResponse> getLecture(ServerRequest serverRequest) {

        Optional<String> queryString = serverRequest.queryParam("lectureId");

        if (!queryString.isPresent()) {
            return ServerResponse.badRequest().build();
        }
        int lectureId = Integer.parseInt(queryString.get());
//        Mono<Lecture> lectureMono = lectureService.getLecture(lectureId);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(null, Lecture.class);
    }

//    Mono<ServerResponse> createLecture(ServerRequest serverRequest);
//    Mono<ServerResponse> changeExposeLecture(ServerRequest serverRequest);
//
/*    public Mono<ServerResponse> enrollLecture(ServerRequest serverRequest){

    }*/
//
//    Mono<ServerResponse> matchTeacher(ServerRequest serverRequest);
//
    public Mono<ServerResponse> getContentList(ServerRequest serverRequest){

        Optional<String> queryString = serverRequest.queryParam("lectureId");

        if(!queryString.isPresent()){
            return ServerResponse.badRequest().build();
        }
        int lectureId = Integer.parseInt(queryString.get());
        Flux<Content> contentFlux = contentService.getContentList(lectureId);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(contentFlux, Content.class);
    }
//    Mono<ServerResponse> uploadContent(ServerRequest serverRequest);
    public Mono<ServerResponse> getContent(ServerRequest serverRequest){

        int lectureId = Integer.parseInt(serverRequest.queryParam("lectureId").get());
        int contentId = Integer.parseInt(serverRequest.queryParam("contentId").get());

        Mono<Content> contentMono = contentService.getContent(lectureId,contentId);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(contentMono, Content.class)
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("데이터 오류"));

    }

    public Mono<ServerResponse> getScore(ServerRequest serverRequest) {
        int lectureId = Integer.parseInt(serverRequest.pathVariable("lectureId"));
        Flux<Score> Scores = scoreRepository.findAll()
                .filter(score -> score.getLectureId()==lectureId);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Scores, Rating.class);
//        Mono<Score> scoreMono = scoreRepository.findScoreById(lectureId,1);
//        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
//        scoreMono.subscribe(System.out::println);
//        return scoreMono
//                .flatMap(score -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(scoreMono, Score.class))
//                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> setScore(ServerRequest serverRequest) {
        Mono<Score> scoreMono = serverRequest.bodyToMono(Score.class)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getMessage());
                    return Mono.error(new RuntimeException(throwable));
        });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                scoreMono.flatMap(this.scoreRepository::save), Score.class);
    }

    public Mono<ServerResponse> changeExposeLecture(ServerRequest serverRequest) {
        int lectureId = Integer.parseInt(serverRequest.pathVariable("lectureId"));
        Mono<Lecture> lectureMono = lectureRepository.findById((long) lectureId)
                .flatMap(x -> Mono.just(new Lecture(x.getLectureId(),x.getTitle(),x.getLocation(),1, LocalDateTime.now(),LocalDateTime.now())));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                lectureMono.flatMap(lectureRepository::save),Lecture.class);


    }

}
