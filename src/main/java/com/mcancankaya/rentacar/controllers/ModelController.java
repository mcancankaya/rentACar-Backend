package com.mcancankaya.rentacar.controllers;

import com.mcancankaya.rentacar.services.ModelService;
import com.mcancankaya.rentacar.services.dtos.requests.models.CreatedModelRequest;
import com.mcancankaya.rentacar.services.dtos.requests.models.UpdatedModelRequest;
import com.mcancankaya.rentacar.services.dtos.responses.models.CreatedModelResponse;
import com.mcancankaya.rentacar.services.dtos.responses.models.ModelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse create(@Valid @RequestBody CreatedModelRequest modelRequest) {
        return modelService.create(modelRequest);
    }

    @PutMapping(path = "/update")
    public CreatedModelResponse update(@Valid @RequestBody UpdatedModelRequest modelRequest) {
        return modelService.update(modelRequest);
    }

    @DeleteMapping(path = "/delete")
    public ModelResponse deleteById(@RequestBody Integer id) {
        return modelService.deleteById(id);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ModelResponse>> getAll() {
        return ResponseEntity.ok(modelService.getAll());
    }

    @GetMapping(path = "/getById")
    public ModelResponse getById(@RequestParam("id") Integer id) {
        return modelService.getById(id);
    }

    @GetMapping(path = "/getByIds")
    public List<ModelResponse> getByIds(@RequestParam("ids") List<Integer> ids) {
        return modelService.getByIds(ids);
    }
}
