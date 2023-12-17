package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public List<Model> getAllModels(){
        return modelRepository.findAll();
    }
}
