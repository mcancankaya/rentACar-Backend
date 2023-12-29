package com.mcancankaya.rentacar.services.rules;

import com.mcancankaya.rentacar.core.exceptions.BusinessException;
import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelRuleService {
    private final ModelRepository modelRepository;
    private final BrandRuleService brandRuleService;

    public void modelNameInThisBrandAlreadyExist(String name, Integer brandId) {
        brandRuleService.brandIsAvailable(brandId);
        Optional<Model> optModel = modelRepository.findByBrandIdAndNameEqualsIgnoreCase(brandId, name);
        if (optModel.isPresent()) {
            throw new BusinessException("Model Name is already exist. Model Name : " + name);
        }
    }

    public Model modelIsAvailable(Integer id) {
        return modelRepository.findById(id).orElseThrow(() -> new BusinessException("Model Not Found."));
    }
}
