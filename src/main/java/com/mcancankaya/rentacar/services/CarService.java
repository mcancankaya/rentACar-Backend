package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car saveOneCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Car car) throws Exception {
        Optional<Car> optCar = carRepository.findById(car.getId());
        if (optCar.isPresent()) {
            Car updatedCar = optCar.get();
            updatedCar.setBodyType(car.getBodyType());
            updatedCar.setYear(car.getYear());
            updatedCar.setColor(car.getColor());
            updatedCar.setModel(car.getModel());
            updatedCar.setFuelType(car.getFuelType());
            return carRepository.save(updatedCar);
        }
        throw new Exception("Car Update Error.");
    }

    public String deleteById(Integer id) {
        try {
            carRepository.deleteById(id);
            return "Car Delete Success.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

