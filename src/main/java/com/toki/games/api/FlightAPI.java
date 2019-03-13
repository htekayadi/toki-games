package com.toki.games.api;

import com.toki.games.dto.BusinessFlightDTO;
import com.toki.games.dto.CheapFlightDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Created by htekayadi
 */
public interface FlightAPI {

    @GET("/cheap")
    Call<List<CheapFlightDTO>> getCheapFlights();

    @GET("/business")
    Call<List<BusinessFlightDTO>> getBusinessFlights();
}
