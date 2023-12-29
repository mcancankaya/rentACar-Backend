package com.mcancankaya.rentacar.services.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedModelResponse {
    private Integer id;
    private String name;
    private Integer brandId;
}
