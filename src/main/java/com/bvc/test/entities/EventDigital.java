package com.bvc.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENT_DIGITAL")
public class EventDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_EVENT")
    private String idEvent;
    @Column(name = "EVENT")
    private String event;
    @Column(name = "PRICE")
    private Integer price;
}
