package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.User;
import com.mcancankaya.rentacar.services.AuthenticationService;
import com.mcancankaya.rentacar.services.dtos.auth.LoginResponse;
import com.mcancankaya.rentacar.services.dtos.auth.SignInRequest;
import com.mcancankaya.rentacar.services.dtos.auth.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> signIn(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
