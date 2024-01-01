package com.mcancankaya.rentacar.services.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    private Integer id;
    private Integer year;
    private String modelName;
    private String bodyType;
    private String fuelType;
    private String color;
}
