package com.toki.games.service;

import com.toki.games.model.Flight;
import org.springframework.data.domain.Page;

import java.io.IOException;

/**
 * FlightService interface for Flights.
 *
 */
public interface FlightService {
    Page<Flight> getFlights(Integer page, Integer perPage, String sortBy) throws IOException;
}
