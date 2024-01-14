package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.RentService;
import com.mcancankaya.rentacar.services.dtos.requests.rents.CreateRentRequest;
import com.mcancankaya.rentacar.services.dtos.requests.rents.UpdateRentRequest;
import com.mcancankaya.rentacar.services.dtos.responses.rents.RentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @PostMapping(path = "/create")
    public RentResponse create(@RequestBody CreateRentRequest createRentRequest) {
        return rentService.create(createRentRequest);
    }

    @PutMapping(path = "/update")
    public RentResponse update(@RequestBody UpdateRentRequest updateRentRequest) {
        return rentService.update(updateRentRequest);
    }

    @DeleteMapping(path = "/delete")
    public RentResponse deleteById(@RequestParam("id") Integer id) {
        return rentService.deleteById(id);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<RentResponse>> getAllRents() {
        return ResponseEntity.ok(rentService.getAllRents());
    }
}
