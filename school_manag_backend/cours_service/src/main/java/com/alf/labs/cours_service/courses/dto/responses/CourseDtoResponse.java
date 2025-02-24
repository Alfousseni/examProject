package com.alf.labs.cours_service.courses.dto.responses;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDtoResponse implements Serializable {
    private Long id;
    private String name;
    private String description;
    private boolean archive;
}
