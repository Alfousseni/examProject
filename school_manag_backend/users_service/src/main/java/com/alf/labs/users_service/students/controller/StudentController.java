package com.alf.labs.users_service.students.controller;

import com.alf.labs.users_service.students.dto.requests.StudentDtoRequest;
import com.alf.labs.users_service.students.dto.responses.StudentDtoResponse;
import com.alf.labs.users_service.students.services.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Getter
@Setter
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<List<StudentDtoResponse>> getAllStudents() {
        List<StudentDtoResponse> students = studentService.getAllStudents().get();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDtoResponse> getStudent(@PathVariable("id") Long id){
        Optional<StudentDtoResponse> student = studentService.getStudentById(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDtoResponse> saveStudent(@RequestBody @Valid StudentDtoRequest studentDtoRequest){
        Optional<StudentDtoResponse> studentDtoResponse = studentService.saveStudent(studentDtoRequest);
        return new ResponseEntity<>(studentDtoResponse.get(), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDtoResponse> updateStudent(@PathVariable("id") Long id, @RequestBody @Valid StudentDtoRequest studentDtoRequest){
        Optional<StudentDtoResponse> studentDtoResponse = studentService.updateStudent(id, studentDtoRequest);
        return new ResponseEntity<>(studentDtoResponse.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id){
        boolean result = studentService.deleteStudent(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
