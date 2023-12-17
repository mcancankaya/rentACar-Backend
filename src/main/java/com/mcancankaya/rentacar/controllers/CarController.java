package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @GetMapping(path = "/getAll")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
}
