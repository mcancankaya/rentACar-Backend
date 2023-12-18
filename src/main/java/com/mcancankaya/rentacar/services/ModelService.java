package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model saveOneModel(Model model) {
        return modelRepository.save(model);
    }

    public Model updateCar(Model model) throws Exception {
        Optional<Model> optModel = modelRepository.findById(model.getId());
        if (optModel.isPresent()) {
            Model updateModel = optModel.get();
            updateModel.setName(model.getName());
            updateModel.setBrand(model.getBrand());
            updateModel.setCars(model.getCars());
            return modelRepository.save(updateModel);
        }
        throw new Exception("Update Error.");
    }

    public String deleteById(Integer id) {
        try {
            modelRepository.deleteById(id);
            return "Delete Success.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
