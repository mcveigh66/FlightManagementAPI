package com.flightmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
