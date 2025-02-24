package com.alf.labs.cours_service.courses.controller;

import com.alf.labs.cours_service.courses.dto.requests.CourseDtoRequest;
import com.alf.labs.cours_service.courses.dto.responses.CourseDtoResponse;
import com.alf.labs.cours_service.courses.services.impl.CourseServiceImpl;
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
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Getter
@Setter
public class CourseController {
    private final CourseServiceImpl courseService;

    @GetMapping
    public ResponseEntity<List<CourseDtoResponse>> getAllCourses() {
        List<CourseDtoResponse> courses = courseService.getAllCourses().get();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDtoResponse> getCourse(@PathVariable("id") Long id){
        Optional<CourseDtoResponse> course = courseService.getCourseById(id);
        return new ResponseEntity<>(course.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDtoResponse> saveCourse(@RequestBody @Valid CourseDtoRequest courseDtoRequest){
        Optional<CourseDtoResponse> courseDtoResponse = courseService.saveCourse(courseDtoRequest);
        return new ResponseEntity<>(courseDtoResponse.get(), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDtoResponse> updateCourse(@PathVariable("id") Long id, @RequestBody @Valid CourseDtoRequest courseDtoRequest){
        Optional<CourseDtoResponse> courseDtoResponse = courseService.updateCourse(id, courseDtoRequest);
        return new ResponseEntity<>(courseDtoResponse.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable("id") Long id){
        boolean result = courseService.deleteCourse(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
