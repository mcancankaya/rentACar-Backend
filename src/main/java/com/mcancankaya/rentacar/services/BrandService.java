package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand saveOneBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public String deleteById(Integer id) {
        try {
            brandRepository.deleteById(id);
            return "Delete success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Brand updateBrand(Brand brand) throws Exception {
        Optional<Brand> optBrand = brandRepository.findById(brand.getId());
        if (optBrand.isPresent()) {
            Brand updatedBrand = optBrand.get();
            updatedBrand.setName(brand.getName().isBlank() ? updatedBrand.getName() : brand.getName());
            updatedBrand.setLogo(brand.getLogo());
            updatedBrand.setModels(brand.getModels());
            return brandRepository.save(updatedBrand);
        }
        throw new Exception("Update Error");
    }


}
