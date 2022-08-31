package com.bvc.test.repository;

import com.bvc.test.entities.EventStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStatusRepository extends CrudRepository<EventStatus, Integer> {
}
