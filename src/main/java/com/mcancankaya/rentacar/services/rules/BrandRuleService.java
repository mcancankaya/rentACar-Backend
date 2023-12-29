package com.mcancankaya.rentacar.services.rules;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandRuleService {
    private final BrandRepository brandRepository;

    public void brandNameAlreadyExist(String name) {
        Optional<Brand> optBrand = brandRepository.findByName(name);
        if (optBrand.isPresent()) {
            throw new BusinessException("Brand name is already exist.");
        }
    }

    public Brand brandIsAvailable(Integer id) {
        return brandRepository.findById(id).orElseThrow(() -> new BusinessException("Brand Not Found."));
    }
}
