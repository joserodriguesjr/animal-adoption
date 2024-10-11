package com.example.adoption.application.controller;

import com.example.adoption.application.form.UpdateAnimalStatusForm;
import com.example.adoption.domain.model.Animal;
import com.example.adoption.domain.service.AnimalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RepositoryRestController("/animals")
@Tag(name = "Animal Controller", description = "Animal Adoption Endpoints")
public class AnimalController {

    private AnimalService animalService;

    @PutMapping(path= "/{id}/status", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Animal> updateStatus(
            @PathVariable(value = "id") Long id,
            @RequestBody UpdateAnimalStatusForm statusForm) {
        Animal.Status status = statusForm.status();
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.updateStatus(id, status));
    }
}
