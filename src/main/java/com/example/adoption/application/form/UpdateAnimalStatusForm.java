package com.example.adoption.application.form;

import com.example.adoption.domain.model.Animal;

public record UpdateAnimalStatusForm(
        Animal.Status status
) {
}
