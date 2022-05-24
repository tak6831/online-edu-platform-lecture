package com.example.onlineeduplatformlecture.service.impl;

import com.example.onlineeduplatformlecture.model.Enrolment;
import com.example.onlineeduplatformlecture.repository.EnrolmentRepository;
import com.example.onlineeduplatformlecture.service.EnrolmentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;

    EnrolmentServiceImpl(EnrolmentRepository enrolmentRepository){
        this.enrolmentRepository = enrolmentRepository;
    }

    // POST /lectures/{lectureId}/enrolment (수강 신청)
    public Mono<Enrolment> enrolmentLectuer(Enrolment enrolment){
        // user ID를 받아오는 곳이 있어야 할 듯,,
        return enrolmentRepository.save(enrolment);
    }
}
