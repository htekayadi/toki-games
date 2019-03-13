package com.toki.games.service;

import com.toki.games.api.FlightAPI;
import com.toki.games.dto.BusinessFlightDTO;
import com.toki.games.dto.CheapFlightDTO;
import com.toki.games.model.Flight;
import com.toki.games.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author htekayadi
 *
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    private FlightAPI flightAPI;

    FlightServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://obscure-caverns-79008.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flightAPI = retrofit.create(FlightAPI.class);
    }

    private static final String ARRIVAL_ASC = "arrivalTime";
    private static final String DEPARTURE_ASC = "departureTime";
    private static final String ARRIVAL_DESC = "-arrivalTime";
    private static final String DEPARTURE_DESC = "-departureTime";

    @Override
    public Page<Flight> getFlights(Integer page, Integer perPage, String sortBy) throws IOException {
        if(flightRepository.count() == 0) {
            List<Flight> flights = new ArrayList<>();

            flights.addAll(getCheapFlights());
            flights.addAll(getBusinessFlights());
            flightRepository.saveAll(flights);
        }

        int pageSize = perPage;
        int currentPage = page - 1;
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, getSortByObject(sortBy));

        return flightRepository.findAll(pageRequest);
    }

    private Sort getSortByObject(String sort){
        if (ARRIVAL_ASC.equals(sort) || DEPARTURE_ASC.equals(sort)){
            return Sort.by(sort.replace("-","")).ascending();
        }else if (ARRIVAL_DESC.equals(sort) || DEPARTURE_DESC.equals(sort)){
            return Sort.by(sort.replace("-","")).descending();
        } else {
            return Sort.unsorted();
        }
    }

    private List<Flight> getCheapFlights() throws IOException {
        Response<List<CheapFlightDTO>> response = flightAPI.getCheapFlights().execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        return response.body()
                .stream()
                .map(CheapFlightDTO::getModel).collect(Collectors.toList());
    }

    private List<Flight> getBusinessFlights() throws IOException {
        Response<List<BusinessFlightDTO>> response = flightAPI.getBusinessFlights().execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        return response.body()
                .stream()
                .map(BusinessFlightDTO::getModel).collect(Collectors.toList());
    }
}
