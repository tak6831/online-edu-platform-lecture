package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Enrolment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


public interface EnrolmentRepository extends ReactiveCrudRepository<Enrolment, Long> {

}
