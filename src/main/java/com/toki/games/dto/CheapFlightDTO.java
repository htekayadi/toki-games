package com.toki.games.dto;

import com.toki.games.model.Flight;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author htekayadi
 *
 */
public class CheapFlightDTO {
    private String id;
    private String departure;
    private String arrival;
    private String departureTime;
    private String arrivalTime;

    public Flight getModel() {
        LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(departureTime)), ZoneId.systemDefault());

        return new Flight(
                this.id,
                this.departure,
                this.arrival,
                getLocalDateTime(departureTime),
                getLocalDateTime(arrivalTime),
                Flight.Type.CHEAP
        );
    }

    private LocalDateTime getLocalDateTime(String timemillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(timemillis)), ZoneId.systemDefault());

    }
}
