package com.toki.games.dto;

import com.toki.games.model.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author htekayadi
 *
 */
public class BusinessFlightDTO {
    private String uuid;
    private String flight;
    private String departure;
    private String arrival;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public Flight getModel() {
        String[] itinerary = flight.split(" -> ");

        return new Flight(
                this.uuid,
                itinerary[0],
                itinerary[1],
                LocalDateTime.parse(departure, formatter),
                LocalDateTime.parse(arrival, formatter),
                Flight.Type.BUSINESS
        );
    }
}
