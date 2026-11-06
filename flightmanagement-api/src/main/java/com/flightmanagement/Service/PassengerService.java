
package com.flightmanagement.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flightmanagement.Repository.PassengerRepository;
import com.flightmanagement.model.Passenger;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Page<Passenger> getAllPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = passengerRepository.findById(id).orElse(null);

        if (existingPassenger != null) {
            existingPassenger.setFirstName(passenger.getFirstName());
            existingPassenger.setLastName(passenger.getLastName());
            existingPassenger.setPhoneNumber(passenger.getPhoneNumber());
            existingPassenger.setCity(passenger.getCity());
            existingPassenger.setAircrafts(passenger.getAircrafts());

            return passengerRepository.save(existingPassenger);
        }

        return null;
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
