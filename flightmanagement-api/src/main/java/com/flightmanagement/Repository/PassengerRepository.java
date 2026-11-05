package com.flightmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
