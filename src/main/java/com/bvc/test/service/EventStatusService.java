package com.bvc.test.service;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.exception.EventStatusException;

import java.util.List;

public interface EventStatusService {
    List<EventStatusDto> findEventStatus() throws EventStatusException;
    void create(EventStatusDto eventStatusDto) throws EventStatusException;
    List<EventStatusDto> findByNumberId(Integer numberId) throws EventStatusException;
}
