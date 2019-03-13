package com.toki.games.controller;

import com.toki.games.model.Flight;
import com.toki.games.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/api/flights")
    public List<Flight> getPerson() throws IOException {
        return flightService.getFlights();
    }
}