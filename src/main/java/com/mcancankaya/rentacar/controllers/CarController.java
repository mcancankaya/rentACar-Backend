package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @GetMapping(path = "/getAll")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping(path = "/save")
    public Car saveOneCar(@RequestBody Car car) {
        return carService.saveOneCar(car);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateOneCar(@RequestBody Car car) {
        try {
            return ResponseEntity.ok(carService.updateCar(car));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCarById(@PathVariable("id") Integer id) {
        return carService.deleteById(id);
    }
}
