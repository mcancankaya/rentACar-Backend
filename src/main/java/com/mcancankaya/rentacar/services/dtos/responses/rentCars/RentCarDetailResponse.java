package com.mcancankaya.rentacar.services.dtos.responses.rentCars;

import com.mcancankaya.rentacar.entities.Car;
import com.mcancankaya.rentacar.services.dtos.responses.cars.CarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentCarDetailResponse {
    private Integer id;
    private Integer rentId;
    private List<CarResponse> cars;
}
