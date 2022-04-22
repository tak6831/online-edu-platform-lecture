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
                .GET("/lectures", lectureHandler::getLectureList)
                .GET("/lectures/{lectureId}", lectureHandler::getLecture)
                .PATCH("/lectures/{lectureId}", lectureHandler::changeExposeLecture)

                .POST("/lectures/{lectureId}/enrolment", lectureHandler::enroleLecture)
                .PATCH("/lectures/{lectureId}/matching", lectureHandler::matchTeacher)

                .GET("/lectures/{lectureId}/contents", lectureHandler::getContentList)
                .POST("/lectures/{lectureId}/contents", lectureHandler::uploadContent)
                .GET("/lectures/{lectureId}/contents/{contentId}", lectureHandler::getContent)

                .GET("/lectures/{lectureId}/score", lectureHandler::getScore)
                .POST("/lectures/{lectureId}/score/{userId}", lectureHandler::setScore)

                .GET("/lectures/{lectureId}/rating", lectureHandler::getRatingList)
                .GET("/lectures/{lectureId}/rating", lectureHandler::getRating)
                .POST("/lectures/{lectureId}/rating", lectureHandler::setRating)
                .build();
    }

}
