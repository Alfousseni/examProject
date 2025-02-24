package com.alf.labs.users_service.students.services;


import com.alf.labs.users_service.students.dto.requests.StudentDtoRequest;
import com.alf.labs.users_service.students.dto.responses.StudentDtoResponse;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Optional<StudentDtoResponse> saveStudent(StudentDtoRequest studentDtoRequest);
    Optional<List<StudentDtoResponse>> getAllStudents();
    Optional<StudentDtoResponse> getStudentById(Long studentId);
    Optional<StudentDtoResponse> updateStudent(Long studentId, StudentDtoRequest studentDtoRequest);
    boolean deleteStudent(Long studentId);
}
