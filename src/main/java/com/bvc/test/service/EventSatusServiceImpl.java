package com.bvc.test.service;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.entities.EventStatus;
import com.bvc.test.exception.EventStatusException;
import com.bvc.test.mapper.EventStatusMapper;
import com.bvc.test.repository.EventStatusRepository;
import com.bvc.test.utils.EventStatusError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventSatusServiceImpl implements EventStatusService{
    private final EventStatusRepository eventStatusRepository;
    private final EventStatusMapper eventStatusMapper;
    @Override
    public List<EventStatusDto> findEventStatus() throws EventStatusException {
        final var lsEventStatus = eventStatusRepository.findAll();
        List<EventStatus> lsEventStatusList = StreamSupport.stream(lsEventStatus.spliterator(), false)
                .collect(Collectors.toList());
        if(CollectionUtils.isEmpty(lsEventStatusList)){
            throw new EventStatusException(EventStatusError.RESOURCE_EVENT_STATUS_NOT_FOUND);
        }
        var lsEventStatusDto = lsEventStatusList.stream().map(eventStatusMapper::toResponse)
                .collect(Collectors.toList());
        return lsEventStatusDto;
    }
    @Override
    public void create(EventStatusDto eventStatusDto) throws EventStatusException {
        log.debug("create (create prms)");
        var eventStatus = eventStatusMapper.toSave(eventStatusDto);
        Optional<EventStatus> list = eventStatusRepository.findById(eventStatus.getId());
        log.error("validate the risk disease");
        final List<EventStatus> eventStatusList = list.stream().collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(eventStatusList)){
            if(eventStatusList.size()>EventStatusError.MAX_DUPLICATE.getCode()){
                throw new EventStatusException(EventStatusError.ERROR_UNIQUE);
            }else{
                throw new EventStatusException(EventStatusError.ERROR_EXIST_REQUEST);
            }
        }
        eventStatusRepository.save(eventStatus);
    }

    @Override
    public List<EventStatusDto> findByNumberId(Integer id) throws EventStatusException {
        Optional<EventStatus> list = eventStatusRepository.findById(id);
        log.error("validate the EventStatus");
        final List<EventStatus> eventStatusList = list.stream().collect(Collectors.toList());
        if(CollectionUtils.isEmpty(eventStatusList)){
            throw new EventStatusException(EventStatusError.RESOURCE_EVENT_STATUS_NOT_FOUND);
        }
        var lsEventStatusDto = eventStatusList.stream().
                map(eventStatusMapper::toResponse).collect(Collectors.toList());
        return lsEventStatusDto;
    }
}
