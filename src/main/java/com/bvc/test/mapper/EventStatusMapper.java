package com.bvc.test.mapper;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.entities.EventStatus;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventStatusMapper {
    EventStatusMapper INSTANCE = Mappers.getMapper(EventStatusMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "event", target = "event")
    EventStatusDto toResponse(EventStatus eventStatus);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "event", target = "event")
    EventStatus toSave(EventStatusDto eventStatusDto);
}
