package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;

    @GetMapping(path = "/getAll")
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @PostMapping(path = "/save")
    public Model saveOneModel(@RequestBody Model model) {
        return modelService.saveOneModel(model);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateModel(@RequestBody Model model) {
        try {
            return ResponseEntity.ok(modelService.updateCar(model));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deleteModelById(@PathVariable("id") Integer id) {
        return modelService.deleteById(id);
    }
}
