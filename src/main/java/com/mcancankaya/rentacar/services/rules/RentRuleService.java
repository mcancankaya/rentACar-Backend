package com.mcancankaya.rentacar.services.rules;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.entities.Rent;
import com.mcancankaya.rentacar.repositories.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentRuleService {
    private final RentRepository rentRepository;

    public BigDecimal calculate(LocalDateTime startDate, LocalDateTime endDate, List<Car> cars) {
        BigDecimal totalPrice = cars.stream().map(Car::getDailyPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        long rentDayCount = ChronoUnit.DAYS.between(startDate, endDate);
        totalPrice = totalPrice.multiply(BigDecimal.valueOf(rentDayCount));
        return totalPrice.add(totalPrice.multiply(BigDecimal.valueOf(0.20)));
    }

    public Rent rentIsAvailable(Integer id) {
        return rentRepository.findById(id).orElseThrow(() -> new BusinessException("Rent is not found."));
    }

}
