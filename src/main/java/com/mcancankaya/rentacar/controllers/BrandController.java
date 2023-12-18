package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService brandService;

    @GetMapping(path = "/getAll")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping(path = "/save")
    public Brand saveOneBrand(@RequestBody Brand brand) {
        return brandService.saveOneBrand(brand);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateBrand(@RequestBody Brand brand) {
        try {
            return ResponseEntity.ok(brandService.updateBrand(brand));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBrandById(@PathVariable("id") Integer id) {
        return brandService.deleteById(id);
    }
}
