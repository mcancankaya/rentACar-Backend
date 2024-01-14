package com.mcancankaya.rentacar.services.dtos.responses.rentCars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentCarResponse {
    private Integer id;
    private Integer carId;
    private Integer rentId;
}
