package com.mcancankaya.rentacar.services.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    private Integer id;
    private Integer modelId;
    private Integer year;
    private BigDecimal dailyPrice;
    private String bodyType;
    private String fuelType;
    private String color;
    private String carStatus;
}
