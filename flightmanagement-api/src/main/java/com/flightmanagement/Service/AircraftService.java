package com.flightmanagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.Repository.AircraftRepository;
import com.flightmanagement.model.Aircraft;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

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

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}
