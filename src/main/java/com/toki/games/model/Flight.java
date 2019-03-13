package com.toki.games.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Flight implements Serializable {

    private static final long serialVersionUID = -6564612331378167541L;

    public Flight(String id,
                  String departure,
                  String arrival,
                  LocalDateTime departureTime,
                  LocalDateTime arrivalTime,
                  Type type) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.type = type;
    }

    private String id;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Type type;

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

    public Type getType() {
        return type;
    }

    public enum Type {
        CHEAP,
        BUSINESS
    }
}
