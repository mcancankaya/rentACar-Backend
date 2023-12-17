package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService brandService;

    @GetMapping(path = "/getAll")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }
}
