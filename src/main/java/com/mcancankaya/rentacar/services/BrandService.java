package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
}
