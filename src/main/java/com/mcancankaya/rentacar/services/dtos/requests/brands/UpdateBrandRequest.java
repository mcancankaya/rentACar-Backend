package com.mcancankaya.rentacar.services.dtos.requests.brands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequest {
    @NotNull
    private Integer id;
    @NotNull
    @Length(min = 2)
    @NotBlank
    private String name;
}
