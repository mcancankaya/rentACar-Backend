package com.mcancankaya.rentacar.services.dtos.requests.cars;

import com.mcancankaya.rentacar.core.validators.EnumCheck;
import com.mcancankaya.rentacar.enums.CarBodyType;
import com.mcancankaya.rentacar.enums.Color;
import com.mcancankaya.rentacar.enums.FuelType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private Integer id;
    @NotNull
    private Integer modelId;
    @NotNull
    @Min(2010)
    private Integer year;
    @NotNull
    @NotBlank
    @EnumCheck(enumClass = CarBodyType.class)
    private String bodyType;
    @NotNull
    @NotBlank
    @EnumCheck(enumClass = FuelType.class)
    private String fuelType;
    @NotNull
    @NotBlank
    @EnumCheck(enumClass = Color.class)
    private String color;
}
