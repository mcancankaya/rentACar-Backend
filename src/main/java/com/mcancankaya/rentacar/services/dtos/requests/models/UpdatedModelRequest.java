package com.mcancankaya.rentacar.services.dtos.requests.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedModelRequest {
    @NotNull
    private Integer id;
    @NotNull
    private Integer brandId;
    @NotNull
    @Length(min = 1)
    @NotBlank
    private String name;
}
