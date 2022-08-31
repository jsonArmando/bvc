package com.bvc.test.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENT_BVC")
public class EventStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENT")
    private Integer id;
    @Column(name = "EVENT")
    private String event;
    @Column(name = "DATE_EVENT")
    private Date date_event;
    @Column(name = "AMOUNT_EVENT")
    private Integer amount_event;
    @Column(name = "COST")
    private Integer cost;
    @Column(name = "DIGITAL_EVENTS_REGISTRATION")
    private String digital_event;
    @Column(name = "REGISTRY_EVENTS_DIGITAL_DESCRIPTION")
    private String digital_event_description;
}
