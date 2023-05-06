package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank
        String title,
        Status status,
        Type contentType,
        LocalDateTime createdTime,
        LocalDateTime updatedTime,
        String url
) {

}
