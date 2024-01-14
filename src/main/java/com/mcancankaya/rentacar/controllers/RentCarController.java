package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.RentCarService;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarDetailResponse;
import com.mcancankaya.rentacar.services.dtos.responses.rentCars.RentCarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rentcar")
@RequiredArgsConstructor
public class RentCarController {
    private final RentCarService rentCarService;

    @GetMapping(path = "/getAll")
    public List<RentCarResponse> getAll() {
        return rentCarService.getAll();
    }

    @GetMapping(path = "/getAllDetails")
    public List<RentCarDetailResponse> getAllDetails(@RequestParam("rentId") Integer rentId) {
        return rentCarService.getAllDetailsByRentId(rentId);
    }

}
