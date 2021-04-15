package com.course.newsletter.data.repository;

import com.course.newsletter.data.entity.SubscriberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<SubscriberEntity, Long> {

}
