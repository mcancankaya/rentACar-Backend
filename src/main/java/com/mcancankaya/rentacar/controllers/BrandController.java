package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.BrandService;
import com.mcancankaya.rentacar.services.dtos.requests.brands.CreateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.requests.brands.UpdateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.responses.brands.CreatedBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.DeletedBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.GetAllBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.UpdatedBrandResponse;
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
    public ResponseEntity<List<GetAllBrandResponse>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping(path = "/save")
    public CreatedBrandResponse saveOneBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.saveOneBrand(createBrandRequest);
    }

    @PutMapping(path = "/update")
    public UpdatedBrandResponse updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.updateBrand(updateBrandRequest);
    }

    @DeleteMapping(path = "/delete")
    public DeletedBrandResponse deleteBrandById(@RequestBody() Integer id) {
        return brandService.deleteById(id);
    }
}
