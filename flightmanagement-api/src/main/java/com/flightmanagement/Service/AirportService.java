package com.flightmanagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.Repository.AirportRepository;
import com.flightmanagement.model.Airport;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport existingAirport = airportRepository.findById(id).orElse(null);

        if (existingAirport != null) {
            existingAirport.setName(airport.getName());
            existingAirport.setCode(airport.getCode());
            existingAirport.setCity(airport.getCity());

            return airportRepository.save(existingAirport);
        }

        return null;
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
