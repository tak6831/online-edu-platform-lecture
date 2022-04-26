package com.example.onlineeduplatformlecture.router;


import com.example.onlineeduplatformlecture.handler.LectureHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class LectureRouter {

    public RouterFunction<ServerResponse> lectureRouter(LectureHandler lectureHandler) {
        return RouterFunctions.route()
                // Lecture
//                .GET("/lectures", lectureHandler::getLectureList)
//                .GET("/lectures/{lectureId}", lectureHandler::getLecture)
//                .POST("/lectures", lectureHandler::createLecture)
//
//                //Enrolment & Matching
//                .POST("/lectures/{lectureId}/enrolment", lectureHandler::enrollLecture)
//                .PATCH("/lectures/{lectureId}/matching", lectureHandler::matchTeacher)
//
//                // Content
//                .GET("/lectures/{lectureId}/contents", lectureHandler::getContentList)
//                .POST("/lectures/{lectureId}/contents", lectureHandler::uploadContent)
//                .GET("/lectures/{lectureId}/contents/{contentId}", lectureHandler::getContent)
//
                // Rating
                .GET("/lectures/{lectureId}/rating", lectureHandler::getRatingList)
                .GET("/lectures/{lectureId}/rating/{ratingId}", lectureHandler::getRating)
                .POST("/lectures/{lectureId}/rating", lectureHandler::setRating)

                // Score
                .GET("/lectures/{lectureId}/score", lectureHandler::getScore)
                .POST("/lectures/{lectureId}/score/{userId}", lectureHandler::setScore)
                .PATCH("/lectures/{lectureId}", lectureHandler::changeExposeLecture)
                .build();
    }

}
