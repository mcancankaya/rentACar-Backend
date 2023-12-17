package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
    private ModelRepository modelRepository;
}
