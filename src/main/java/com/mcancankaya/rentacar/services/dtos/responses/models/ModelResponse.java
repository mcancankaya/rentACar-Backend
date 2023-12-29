package com.mcancankaya.rentacar.services.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelResponse {
    private Integer id;
    private String brandName;
    private String name;
}
