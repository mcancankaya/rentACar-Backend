package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }
}
