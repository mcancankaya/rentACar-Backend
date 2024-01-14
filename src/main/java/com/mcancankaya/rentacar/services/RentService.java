package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.entities.Rent;
import com.mcancankaya.rentacar.entities.RentCar;
import com.mcancankaya.rentacar.enums.CarStatus;
import com.mcancankaya.rentacar.repositories.RentRepository;
import com.mcancankaya.rentacar.services.dtos.requests.cars.UpdateCarRequest;
import com.mcancankaya.rentacar.services.dtos.requests.rents.CreateRentRequest;
import com.mcancankaya.rentacar.services.dtos.requests.rents.UpdateRentRequest;
import com.mcancankaya.rentacar.services.dtos.responses.cars.CarResponse;
import com.mcancankaya.rentacar.services.dtos.responses.rents.RentResponse;
import com.mcancankaya.rentacar.services.rules.CarRuleService;
import com.mcancankaya.rentacar.services.rules.RentRuleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService {
    private final RentRepository rentRepository;
    private final RentCarService rentCarService;
    private final CarService carService;

    private final ModelMapperService modelMapperService;
    private final RentRuleService rentRuleService;
    private final CarRuleService carRuleService;

    @Transactional
    public RentResponse create(CreateRentRequest createRentRequest) {
        List<CarResponse> carResponses = carService.getByIds(createRentRequest.getCarIds());
        List<Car> cars = carResponses.stream().map(carResponse -> modelMapperService.forResponse().map(carResponse, Car.class)).toList();

        //Car Status Check
        cars.forEach(car -> carRuleService.carStatusIsAvailable(car.getId()));

        //Calculate rent price
        BigDecimal totalPrice = rentRuleService.calculate(createRentRequest.getStartDate(), createRentRequest.getEndDate(), cars);

        Rent rent = modelMapperService.forRequest().map(createRentRequest, Rent.class);
        rent.setPrice(totalPrice);

        Rent createdRent = rentRepository.save(rent);
        cars.forEach(car -> {
            car.setCarStatus(CarStatus.RENTED);
            rentCarService.create(RentCar.builder().car(car).rent(createdRent).build());
            carService.update(modelMapperService.forRequest().map(car, UpdateCarRequest.class));
        });

        return modelMapperService.forResponse().map(createdRent, RentResponse.class);
    }

    public RentResponse update(UpdateRentRequest updateRentRequest) {
        /*
         * TODO: Update
         */
        throw new BusinessException("TODO");
    }

    public RentResponse deleteById(Integer id) {
        // TODO: Delete By Id.
        throw new BusinessException("TODO");
    }

    public List<RentResponse> getAllRents() {
        List<Rent> rents = rentRepository.findAll();
        return rents.stream().map((rent) -> modelMapperService.forResponse().map(rent, RentResponse.class)).toList();
    }
}
