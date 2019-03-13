package com.toki.games.service;

import com.toki.games.model.Flight;

import java.io.IOException;
import java.util.List;

/**
 * PersonService interface for Persons.
 *
 */
public interface FlightService {
    List<Flight> getFlights() throws IOException;
}
