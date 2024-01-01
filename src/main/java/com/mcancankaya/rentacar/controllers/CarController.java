package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.CarService;
import com.mcancankaya.rentacar.services.dtos.requests.cars.CreateCarRequest;
import com.mcancankaya.rentacar.services.dtos.requests.cars.UpdateCarRequest;
import com.mcancankaya.rentacar.services.dtos.responses.cars.CarResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse create(@Valid @RequestBody CreateCarRequest createCarRequest) {
        return carService.create(createCarRequest);
    }

    @PutMapping(path = "/update")
    public CarResponse update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.update(updateCarRequest);
    }

    @DeleteMapping(path = "/delete")
    public CarResponse deleteById(@RequestBody Integer id) {
        return carService.deleteById(id);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CarResponse>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping(path = "/getById")
    public CarResponse getById(@RequestParam("id") Integer id) {
        return carService.getById(id);
    }

    @GetMapping(path = "/getByIds")
    public List<CarResponse> getByIds(@RequestParam("ids") List<Integer> ids) {
        return carService.getByIds(ids);
    }
}
