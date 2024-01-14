package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.RentCar;
import com.mcancankaya.rentacar.repositories.RentCarRepository;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarDetailResponse;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentCarService {
    private final RentCarRepository rentCarRepository;
    private final ModelMapperService modelMapperService;

    public RentCar create(RentCar rentCar) {
        return rentCarRepository.save(rentCar);
    }

    public List<RentCar> deleteByRentId(Integer rentId) {
        return rentCarRepository.deleteAllByRent_Id(rentId);
    }

    public void delete(List<RentCar> rentCars) {
        rentCarRepository.deleteAll(rentCars);
    }

    public RentCar update(RentCar rentCar) {
        return rentCarRepository.save(rentCar);
    }

    public List<RentCarResponse> getAll() {
        List<RentCar> rentCars = rentCarRepository.findAll();
        return rentCars.stream().map(rentCar -> modelMapperService.forResponse().map(rentCar, RentCarResponse.class)).toList();
    }

    public List<RentCarDetailResponse> getAllDetailsByRentId(Integer rentId) {
        List<RentCar> rentCars = rentCarRepository.findAllByRentId(rentId);
        return rentCars.stream().map(rentCar -> modelMapperService.forResponse().map(rentCar, RentCarDetailResponse.class)).toList();
    }
}
