package com.example.adoption.domain.model.projection;

import com.example.adoption.domain.model.Animal;
import org.springframework.data.rest.core.config.Projection;
import java.time.LocalDate;
import java.time.Period;

@Projection(name = "animalOut", types = Animal.class)
public interface AnimalOut {
    Long getId();
    String getName();
    String getDescription();
    String getImageURL();
    String getCategory();
    LocalDate getBirthDate();

    default int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    Animal.Status getStatus();
}



