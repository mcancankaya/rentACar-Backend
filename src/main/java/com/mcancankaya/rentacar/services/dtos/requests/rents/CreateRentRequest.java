package com.mcancankaya.rentacar.services.dtos.requests.rents;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentRequest {
    @Null
    private Integer id;
    @NotNull
    private List<Integer> carIds;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    private Integer kilometers;
    @NotNull
    private String fuelTank;
}
