package com.example.adoption.domain.repository;

import com.example.adoption.domain.model.Animal;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "animals", path = "animals")
@Tag(name = "Animal Controller", description = "Animal Management Endpoints")
public interface AnimalRepository extends JpaRepository<Animal, Long> {}
