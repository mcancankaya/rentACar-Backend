package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;

    @GetMapping(path = "/getAll")
    public List<Model> getAllModels(){
        return modelService.getAllModels();
    }
}
