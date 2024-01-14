package com.mcancankaya.rentacar.services.rules;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.enums.CarStatus;
import com.mcancankaya.rentacar.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRuleService {
    private final CarRepository carRepository;
    private final ModelRuleService modelRuleService;

    public void checkModelIsAvailable(Integer modelId) {
        modelRuleService.modelIsAvailable(modelId);
    }

    public Car carIsAvailable(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Car Not Found."));
    }

    public Car carStatusIsAvailable(Integer id) {
        Car car = carIsAvailable(id);
        if (!car.getCarStatus().equals(CarStatus.AVAILABLE))
            throw new BusinessException("Car Status Is Not Available.");
        return car;
    }
}
