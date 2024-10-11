package com.example.adoption.domain.service;


import com.example.adoption.domain.model.Animal;
import com.example.adoption.domain.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AnimalServiceTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalService animalService;

    private Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal();
        animal.setId(1L);
        animal.setName("Bobby");
        animal.setDescription("Cute dog");
        animal.setImageURL("https://image.com/bobby");
        animal.setCategory("Dog");
        animal.setBirthDate(LocalDate.of(2020, 1, 1));
        animal.setStatus(Animal.Status.DISPONIVEL);
        animalRepository.save(animal);
    }

    @Test
    public void testUpdateStatus() {
        // Arrange
        Animal.Status newStatus = Animal.Status.ADOTADO;

        // Act
        Animal updatedAnimal = animalService.updateStatus(animal.getId(), newStatus);

        // Assert
        assertEquals(newStatus, updatedAnimal.getStatus());
        assertEquals(animal.getId(), updatedAnimal.getId());
    }

    @Test
    public void testUpdateStatus_AnimalNotFound() {
        // Arrange
        Long nonExistentId = 999L;
        Animal.Status newStatus = Animal.Status.ADOTADO;

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> {
            animalService.updateStatus(nonExistentId, newStatus);
        });
    }

}
