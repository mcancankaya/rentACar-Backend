package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
}

