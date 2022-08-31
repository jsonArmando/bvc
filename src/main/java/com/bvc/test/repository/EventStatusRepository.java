package com.bvc.test.repository;

import com.bvc.test.entities.EventStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventStatusRepository extends CrudRepository<EventStatus, Integer> {
    List<EventStatus> findByIdEvent(String idEvent);
    List<EventStatus> findByDigitalEvent(String digitalEvent);
}
