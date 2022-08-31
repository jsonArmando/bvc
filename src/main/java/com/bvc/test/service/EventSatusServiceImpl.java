package com.bvc.test.service;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.entities.EventDigital;
import com.bvc.test.entities.EventStatus;
import com.bvc.test.exception.EventStatusException;
import com.bvc.test.mapper.EventStatusMapper;
import com.bvc.test.repository.EventDigitalRepository;
import com.bvc.test.repository.EventStatusRepository;
import com.bvc.test.utils.EventStatusError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
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

    private final EventDigitalRepository eventDigitalRepository;
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
        EventDigital eventDigital = eventDigitalRepository.findByIdEvent(eventStatus.getIdEvent());
        if(eventDigital!=null){
            eventStatus.setAmount_event(eventDigital.getPrice() * eventStatus.getAmount_event());
            eventStatus.setEvent(eventDigital.getEvent());
            eventStatusRepository.save(eventStatus);
        }else {
            throw new EventStatusException(EventStatusError.ERROR_EVENT);
        }
    }

    @Override
    public List<EventStatusDto> findByNumberId(String idEvent) throws EventStatusException {
        List<EventStatus> list = eventStatusRepository.findByIdEvent(idEvent);
        if(CollectionUtils.isEmpty(list)){
            throw new EventStatusException(EventStatusError.RESOURCE_EVENT_STATUS_NOT_FOUND);
        }
        var lsEventStatusDto = list.stream().
                map(eventStatusMapper::toResponse).collect(Collectors.toList());
        return lsEventStatusDto;
    }

    @Override
    public List<EventStatusDto> findByDigital(String digitalEvent) throws EventStatusException {
        List<EventStatus> list = eventStatusRepository.findByDigitalEvent(digitalEvent);
        if(CollectionUtils.isEmpty(list)){
            throw new EventStatusException(EventStatusError.RESOURCE_EVENT_STATUS_NOT_FOUND);
        }
        var lsEventStatusDto = list.stream().
                map(eventStatusMapper::toResponse).collect(Collectors.toList());
        return lsEventStatusDto;
    }
}
