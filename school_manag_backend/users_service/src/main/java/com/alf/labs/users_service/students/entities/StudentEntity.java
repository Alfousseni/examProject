package com.alf.labs.users_service.students.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "students")
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String emailPro;

    @Column(nullable = false)
    private String emailPerso;

    @Column(nullable = false)
    private String phoneNumber;

    private String address;

    private boolean archive;

    private String registrationNu;

}
