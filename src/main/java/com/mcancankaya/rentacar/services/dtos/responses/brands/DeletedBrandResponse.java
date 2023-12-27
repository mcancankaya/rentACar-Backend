package com.mcancankaya.rentacar.services.dtos.responses.brands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeletedBrandResponse {
    private Integer id;
}
