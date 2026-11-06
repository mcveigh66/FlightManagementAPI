package com.flightmanagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagement.Service.AirportService;
import com.flightmanagement.model.Airport;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Airport airport = airportService.getAirportById(id);

        if (airport == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(airport);
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport savedAirport = airportService.createAirport(airport);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(
            @PathVariable Long id,
            @RequestBody Airport airport) {

        Airport updatedAirport = airportService.updateAirport(id, airport);

        if (updatedAirport == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        if (airportService.getAirportById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        airportService.deleteAirport(id);

        return ResponseEntity.noContent().build();
    }
}
