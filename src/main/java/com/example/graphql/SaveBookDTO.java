package com.example.graphql;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SaveBookDTO(@NotBlank String name, @Positive Integer pageCount, @NotBlank String authorId) {
}
