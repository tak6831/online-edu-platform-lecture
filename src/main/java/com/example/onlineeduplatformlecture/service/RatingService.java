package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Rating;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {


    public List<Rating> getRatingList() {
        System.out.println("별점 리스트 가져오기");
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating(0,0,0,1,"졸려요"));
        ratingList.add(new Rating(1,0,1,2,"잠와요"));
        ratingList.add(new Rating(2,0,2,5,"배고파요"));
        System.out.println(ratingList.toString());
        return ratingList;
    }
    public float getRating(){
        System.out.println("별점 평균 가져오기");
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating(0,0,0,1,"졸려요"));
        ratingList.add(new Rating(1,0,1,2,"잠와요"));
        ratingList.add(new Rating(2,0,2,5,"배고파요"));
        float total = 0;
        for(Rating item : ratingList){
            total += item.getRating();
        }
        return total/ratingList.size();
    }
    public Rating saveRating(Rating rating) {

        return rating;
    }
}
