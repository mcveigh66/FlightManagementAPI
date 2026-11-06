
package com.flightmanagement.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flightmanagement.Repository.AircraftRepository;
import com.flightmanagement.model.Aircraft;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    // Get all aircraft with pagination and sorting
    public Page<Aircraft> getAllAircraft(Pageable pageable) {
        return aircraftRepository.findAll(pageable);
    }

    // Get aircraft by ID
    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    // Create aircraft
    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    // Update aircraft
    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Aircraft existingAircraft = aircraftRepository.findById(id).orElse(null);

        if (existingAircraft != null) {
            existingAircraft.setType(aircraft.getType());
            existingAircraft.setAirlineName(aircraft.getAirlineName());
            existingAircraft.setNumberOfPassengers(aircraft.getNumberOfPassengers());

            return aircraftRepository.save(existingAircraft);
        }

        return null;
    }

    // Delete aircraft
    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}

