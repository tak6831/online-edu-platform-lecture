package com.example.onlineeduplatformlecture.controller;


import com.example.onlineeduplatformlecture.handler.LectureHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class LectureController {

    public RouterFunction<ServerResponse> LectureRouter(LectureHandler lectureHandler) {
        return RouterFunctions.route()
                .GET("/lecture", lectureHandler::getLectureList)
                .GET("/lecture/{lectureId}", lectureHandler::getLecture)
                .PATCH("/lecture/{lectureId}", lectureHandler::changeExposeLecture)

                .POST("/lecture/{lectureId}/enrolment", lectureHandler::enroleLecture)
                .PATCH("/lecture/{lectureId}/matching", lectureHandler::matchTeacher)

                .GET("/lecture/{lectureId}/content", lectureHandler::getContentList)
                .POST("/lecture/{lectureId}/content", lectureHandler::uploadContent)
                .GET("/lecture/{lectureId}/content/{contentId}", lectureHandler::getContent)

                .GET("/lecture/{lectureId}/score", lectureHandler::getScore)
                .POST("/lecture/{lectureId}/score/{userId}", lectureHandler::setScore)

                .GET("/lecture/{lectureId}/rating", lectureHandler::getRatingList)
                .GET("/lecture/{lectureId}/rating", lectureHandler::getRating)
                .POST("/lecture/{lectureId}/rating", lectureHandler::setRating)
                .build();
    }

}
