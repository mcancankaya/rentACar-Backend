package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.repositories.BrandRepository;
import com.mcancankaya.rentacar.services.dtos.requests.brands.CreateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.requests.brands.UpdateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.responses.brands.*;
import com.mcancankaya.rentacar.services.rules.BrandRuleService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandRuleService brandRuleService;


    public BrandResponse create(CreateBrandRequest createBrandRequest) {
        brandRuleService.brandNameAlreadyExist(createBrandRequest.getName());

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        Brand createdBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(createdBrand, BrandResponse.class);
    }

    public BrandResponse update(UpdateBrandRequest updateBrandRequest) {
        brandRuleService.brandIsAvailable(updateBrandRequest.getId());
        brandRuleService.brandNameAlreadyExist(updateBrandRequest.getName());

        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        Brand updatedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(updatedBrand, BrandResponse.class);
    }

    public BrandResponse deleteById(Integer id) {
        Brand brand = brandRuleService.brandIsAvailable(id);

        brandRepository.delete(brand);
        BrandResponse brandResponse = modelMapperService.forResponse().map(brand, BrandResponse.class);
        return brandResponse;
    }

    public List<BrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResponse> responseList = brands.stream().map(brand -> modelMapperService.forResponse().map(brand, BrandResponse.class)).toList();
        return responseList;
    }

    public BrandResponse getById(Integer id) {
        Brand brand = brandRuleService.brandIsAvailable(id);
        BrandResponse brandResponse = modelMapperService.forResponse().map(brand, BrandResponse.class);
        return brandResponse;
    }

    public List<BrandResponse> getByIds(List<Integer> ids) {
        List<Brand> brands = brandRepository.findAllById(ids);
        return brands.stream().map(brand -> modelMapperService.forResponse().map(brand, BrandResponse.class)).toList();
    }
}
