package com.toki.games.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toki.games.model.Flight;
import com.toki.games.service.FlightService;
import com.toki.games.utils.RESTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

import static com.toki.games.utils.RequestUtil.getFilteredFieldNames;
import static com.toki.games.utils.RequestUtil.getParameterValueByKey;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/api/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPerson(@RequestParam MultiValueMap<String, String> params) throws IOException {
        String sort = getParameterValueByKey(params, "sort", "");
        String pageValue = getParameterValueByKey(params, "page", "1");
        String perPageValue = getParameterValueByKey(params, "per_page", "5");
        String fields = getParameterValueByKey(params, "fields", "");

        Integer page = 1;
        try {
            page = Integer.valueOf(pageValue);
        } catch (NumberFormatException e){
            page = 1;
        }

        Integer perPage = 5;
        try {
            perPage = Integer.valueOf(perPageValue);
        } catch (NumberFormatException e){
            perPage = 5;
        }

        Set<String> filteredFieldNames = getFilteredFieldNames(fields);
        ObjectMapper om = RESTUtil.getObjectMapper(filteredFieldNames);

        Page<Flight> pageFlights = flightService.getFlights(page, perPage, sort);
        return ResponseEntity.ok(om.writeValueAsString(pageFlights));
    }
}