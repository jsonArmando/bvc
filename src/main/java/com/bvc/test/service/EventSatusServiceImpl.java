package com.bvc.test.service;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.exception.EventStatusException;
import com.bvc.test.mapper.EventStatusMapper;
import com.bvc.test.repository.EventStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class EventSatusServiceImpl implements EventStatusService{
    private final EventStatusRepository eventStatusRepository;
    private final EventStatusMapper eventStatusMapper;
    @Override
    public List<EventStatusDto> findEventStatus() throws EventStatusException {
        return null;
    }

    @Override
    public void create(EventStatusDto eventStatusDto) throws EventStatusException {

    }

    @Override
    public List<EventStatusDto> findByNumberId(Integer numberId) throws EventStatusException {
        return null;
    }
}
