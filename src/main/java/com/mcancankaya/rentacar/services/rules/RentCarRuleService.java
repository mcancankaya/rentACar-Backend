package com.mcancankaya.rentacar.services.rules;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.entities.RentCar;
import com.mcancankaya.rentacar.repositories.RentCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentCarRuleService {
    private final RentCarRepository rentCarRepository;

    public RentCar rentCarIsAvailable(Integer id) {
        return rentCarRepository.findById(id).orElseThrow(() -> new BusinessException("RentCar is not found."));
    }
}
