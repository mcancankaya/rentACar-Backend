package com.mcancankaya.rentacar.services;

import com.mcancankaya.rentacar.core.mapping.ModelMapperService;
import com.mcancankaya.rentacar.entities.Model;
import com.mcancankaya.rentacar.repositories.ModelRepository;
import com.mcancankaya.rentacar.services.dtos.requests.models.CreatedModelRequest;
import com.mcancankaya.rentacar.services.dtos.requests.models.UpdatedModelRequest;
import com.mcancankaya.rentacar.services.dtos.responses.models.CreatedModelResponse;
import com.mcancankaya.rentacar.services.dtos.responses.models.ModelResponse;
import com.mcancankaya.rentacar.services.rules.ModelRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final ModelRuleService modelRuleService;

    public CreatedModelResponse create(CreatedModelRequest modelRequest) {
        modelRuleService.modelNameInThisBrandAlreadyExist(modelRequest.getName(), modelRequest.getBrandId());

        Model model = modelMapperService.forRequest().map(modelRequest, Model.class);
        Model createdModel = modelRepository.save(model);
        return modelMapperService.forResponse().map(createdModel, CreatedModelResponse.class);
    }

    public CreatedModelResponse update(UpdatedModelRequest modelRequest) {
        modelRuleService.modelIsAvailable(modelRequest.getId());
        modelRuleService.modelNameInThisBrandAlreadyExist(modelRequest.getName(), modelRequest.getBrandId());

        Model model = modelMapperService.forRequest().map(modelRequest, Model.class);
        Model updatedModel = modelRepository.save(model);
        return modelMapperService.forResponse().map(updatedModel, CreatedModelResponse.class);
    }

    public ModelResponse deleteById(Integer id) {
        Model model = modelRuleService.modelIsAvailable(id);

        modelRepository.delete(model);
        return modelMapperService.forResponse().map(model, ModelResponse.class);
    }

    public List<ModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(model -> modelMapperService.forResponse().map(model, ModelResponse.class)).toList();
    }

    public ModelResponse getById(Integer id) {
        Model model = modelRuleService.modelIsAvailable(id);
        return modelMapperService.forResponse().map(model, ModelResponse.class);
    }

    public List<ModelResponse> getByIds(List<Integer> ids) {
        return modelRepository.findAllById(ids).stream().map(model -> modelMapperService.forResponse().map(model, ModelResponse.class)).toList();
    }

    public List<ModelResponse> getByBrandId(Integer brandId) {
        return modelRepository.findAllByBrand_Id(brandId).stream().map(model -> modelMapperService.forResponse().map(model, ModelResponse.class)).toList();
    }
}
