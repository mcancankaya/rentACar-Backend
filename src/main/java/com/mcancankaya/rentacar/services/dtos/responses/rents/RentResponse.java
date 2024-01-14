package com.mcancankaya.rentacar.services.dtos.responses.rents;

import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentResponse {
    private Integer id;
    private BigDecimal totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer kilometers;
    private String fuelTank;
    private List<RentCarResponse> rentCar;
}
