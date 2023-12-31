package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.BrandService;
import com.mcancankaya.rentacar.services.dtos.responses.brands.*;
import com.mcancankaya.rentacar.services.dtos.requests.brands.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService brandService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponse create(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.create(createBrandRequest);
    }

    @PutMapping(path = "/update")
    public BrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(updateBrandRequest);
    }

    @DeleteMapping(path = "/delete")
    public BrandResponse deleteById(@RequestBody Integer id) {
        return brandService.deleteById(id);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<BrandResponse>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @GetMapping(path = "/getById")
    public BrandResponse getById(@RequestParam("id") Integer id) {
        return brandService.getById(id);
    }

    @GetMapping(path = "/getByIds")
    public List<BrandResponse> getByIds(@RequestParam("ids") List<Integer> ids) {
        return brandService.getByIds(ids);
    }
}
