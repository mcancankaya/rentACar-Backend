package com.mcancankaya.rentacar.services.dtos.requests.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedModelRequest {
    private Integer modelId;
    @NotNull
    @JsonAlias("brandId")
    private Integer brandId;

    @NotNull
    @Length(min = 1)
    @NotBlank
    private String name;

}
