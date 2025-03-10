package com.alf.labs.cours_service.courses.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDtoRequest implements Serializable {
    @NotBlank(message = "Name is required!")
    private String name;
    private String description;
}
