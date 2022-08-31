package com.bvc.test.repository;

import com.bvc.test.entities.EventDigital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDigitalRepository extends CrudRepository<EventDigital, Integer> {
    EventDigital findByIdEvent(String idEvent);
}