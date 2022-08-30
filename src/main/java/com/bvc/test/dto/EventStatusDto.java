package com.bvc.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventStatusDto {
    private Integer id;
    private String event;
    private Date date_event;
    private Integer amount_event;
    private Integer cost;
    private String digital_event;
    private String digital_event_description;
}
