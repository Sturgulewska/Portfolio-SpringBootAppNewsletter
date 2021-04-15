package com.course.newsletter.service;

import com.course.newsletter.data.entity.SubscriberEntity;
import com.course.newsletter.data.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Optional<SubscriberEntity> findById(Long id){
        return subscriberRepository.findById(id);
    }
}
