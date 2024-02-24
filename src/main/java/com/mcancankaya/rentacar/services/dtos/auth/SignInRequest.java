package com.mcancankaya.rentacar.services.dtos.auth;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
