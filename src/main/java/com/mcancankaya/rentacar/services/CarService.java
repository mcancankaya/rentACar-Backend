package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.enums.CarStatus;
import com.mcancankaya.rentacar.repositories.CarRepository;
import com.mcancankaya.rentacar.services.dtos.requests.cars.CreateCarRequest;
import com.mcancankaya.rentacar.services.dtos.requests.cars.UpdateCarRequest;
import com.mcancankaya.rentacar.services.dtos.responses.cars.CarResponse;
import com.mcancankaya.rentacar.services.rules.CarRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarRuleService carRuleService;
    private final ModelMapperService modelMapperService;

    public CarResponse create(CreateCarRequest createCarRequest) {
        carRuleService.checkModelIsAvailable(createCarRequest.getModelId());

        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        Car addedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(addedCar, CarResponse.class);
    }

    public CarResponse update(UpdateCarRequest updateCarRequest) {
        carRuleService.checkModelIsAvailable(updateCarRequest.getModelId());
        carRuleService.carIsAvailable(updateCarRequest.getId());

        Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        Car updatedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(updatedCar, CarResponse.class);
    }

    public CarResponse deleteById(Integer id) {
        Car car = carRuleService.carIsAvailable(id);

        carRepository.delete(car);
        return modelMapperService.forResponse().map(car, CarResponse.class);
    }

    public List<CarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> modelMapperService.forResponse().map(car, CarResponse.class)).toList();
    }

    public CarResponse getById(Integer id) {
        Car car = carRuleService.carIsAvailable(id);
        return modelMapperService.forResponse().map(car, CarResponse.class);
    }

    public List<CarResponse> getByIds(List<Integer> ids) {
        List<Car> cars = carRepository.findAllById(ids);
        return cars.stream().map((car) -> modelMapperService.forResponse().map(car, CarResponse.class)).toList();
    }
}

