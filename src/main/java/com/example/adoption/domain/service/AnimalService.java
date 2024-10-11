package com.example.adoption.domain.service;

import com.example.adoption.domain.model.Animal;
import com.example.adoption.domain.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public Animal updateStatus(Long id, Animal.Status status) {
        Animal animal = animalRepository.findById(id).orElseThrow();
        animal.setStatus(status);
        return animalRepository.save(animal);
    };
}
