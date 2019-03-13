package com.toki.games.service;

import com.toki.games.api.FlightAPI;
import com.toki.games.dto.BusinessFlightDTO;
import com.toki.games.dto.CheapFlightDTO;
import com.toki.games.model.Flight;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author htekayadi
 *
 */
@Service
public class FlightServiceImpl implements FlightService {

    private FlightAPI flightAPI;

    FlightServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://obscure-caverns-79008.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flightAPI = retrofit.create(FlightAPI.class);
    }

    @Override
    public List<Flight> getFlights() throws IOException {
        List<Flight> flights = getCheapFlights();

        List<Flight> businessFlights = getBusinessFlights();
        flights.addAll(businessFlights);

        return flights;
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
