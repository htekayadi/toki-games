package com.toki.games.repository;

import com.toki.games.model.Flight;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {
}
