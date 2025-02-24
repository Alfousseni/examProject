package com.alf.labs.users_service.students.dto.requests;

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
public class StudentDtoRequest implements Serializable {
    @NotBlank(message = "Firstname is required!")
    private String firstName;
    @NotBlank(message = "Lastname is required!")
    private String lastName;
    private String emailPro;
    @NotBlank(message = "Personal email is required!")
    private String emailPerso;
    @NotBlank(message = "PhoneNumber is required!")
    private String phoneNumber;
    private String address;
    private String registrationNu;
}
