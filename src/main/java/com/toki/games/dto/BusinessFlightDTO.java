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

    public String getDepartureLocation() {
        String[] itinerary = this.flight.split(" -> ");
        return itinerary[0].trim();
    }

    public String getArrivalLocation() {
        String[] itinerary = this.flight.split(" -> ");
        return itinerary[1].trim();
    }

    public Flight getModel() {
        return new Flight(
                this.uuid,
                getDepartureLocation(),
                getArrivalLocation(),
                LocalDateTime.parse(departure, formatter),
                LocalDateTime.parse(arrival, formatter),
                Flight.FlightClass.BUSINESS
        );
    }
}
