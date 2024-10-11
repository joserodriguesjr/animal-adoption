package com.example.adoption.application.form;

import com.example.adoption.domain.model.Animal;

public record UpdateStatusForm(
        Animal.Status status
) {
}
