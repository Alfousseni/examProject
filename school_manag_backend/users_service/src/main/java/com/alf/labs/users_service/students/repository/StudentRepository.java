package com.alf.labs.users_service.students.repository;

import com.alf.labs.users_service.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity , Long> {
    Optional<StudentEntity> findByEmailPro(String emailPro);
    Optional<StudentEntity> findByEmailPerso(String emailPerso);
}
