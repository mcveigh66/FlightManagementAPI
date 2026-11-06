package com.flightmanagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.Repository.CityRepository;
import com.flightmanagement.model.City;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = cityRepository.findById(id).orElse(null);

        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setState(city.getState());
            existingCity.setPopulation(city.getPopulation());

            return cityRepository.save(existingCity);
        }

        return null;
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
