package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.Brand;
import com.mcancankaya.rentacar.repositories.BrandRepository;
import com.mcancankaya.rentacar.services.dtos.requests.brands.CreateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.requests.brands.UpdateBrandRequest;
import com.mcancankaya.rentacar.services.dtos.responses.brands.CreatedBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.DeletedBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.GetAllBrandResponse;
import com.mcancankaya.rentacar.services.dtos.responses.brands.UpdatedBrandResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;


    public CreatedBrandResponse saveOneBrand(CreateBrandRequest createBrandRequest) {

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        Brand createdBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);

    }

    public UpdatedBrandResponse updateBrand(UpdateBrandRequest updateBrandRequest) {

        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        Brand updatedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
    }

    public DeletedBrandResponse deleteById(Integer id) {
        brandRepository.deleteById(id);
        return DeletedBrandResponse.builder().id(id).build();
    }

    public List<GetAllBrandResponse> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> responseList = brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).toList();
        return responseList;
    }


}
