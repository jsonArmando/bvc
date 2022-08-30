package com.bvc.test.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventStatus that = (EventStatus) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
