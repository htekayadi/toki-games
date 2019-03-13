package com.toki.games.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@JsonFilter("flight")
public class Flight implements Serializable {

    private static final long serialVersionUID = -6564612331378167541L;

    public Flight() {

    }

    public Flight(String referenceId,
                  String departure,
                  String arrival,
                  LocalDateTime departureTime,
                  LocalDateTime arrivalTime,
                  FlightClass type) {
        this.referenceId = referenceId;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "reference_id")
    String referenceId;

    @Column(name = "departure")
    String departure;

    @Column(name = "arrival")
    String arrival;

    @Column(name = "departure_time")
    LocalDateTime departureTime;

    @Column(name = "arrival_time")
    LocalDateTime arrivalTime;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    FlightClass type;

    public String getDeparture() {
        return departure;
    }


    public String getArrival() {
        return arrival;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public FlightClass getType() {
        return type;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setType(FlightClass type) {
        this.type = type;
    }

    public enum FlightClass {
        CHEAP,
        BUSINESS
    }
}
