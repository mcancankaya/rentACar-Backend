package com.mcancankaya.rentacar.services.dtos.responses.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedBrandResponse {
    private Integer id;
    private String name;
}
