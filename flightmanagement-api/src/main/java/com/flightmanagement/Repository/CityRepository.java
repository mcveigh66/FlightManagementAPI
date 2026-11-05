package com.flightmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}