package com.toki.games.dto;

import com.toki.games.model.Flight;
import com.toki.games.utils.DateUtil;

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
        return new Flight(
                this.id,
                this.departure,
                this.arrival,
                DateUtil.getLocalDateTime(departureTime),
                DateUtil.getLocalDateTime(arrivalTime),
                Flight.FlightClass.CHEAP
        );
    }
}
