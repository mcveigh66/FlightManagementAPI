package com.flightmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
