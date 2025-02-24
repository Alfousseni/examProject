package com.alf.labs.cours_service.courses.services;



import com.alf.labs.cours_service.courses.dto.requests.CourseDtoRequest;
import com.alf.labs.cours_service.courses.dto.responses.CourseDtoResponse;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Optional<CourseDtoResponse> saveCourse(CourseDtoRequest studentDtoRequest);
    Optional<List<CourseDtoResponse>> getAllCourses();
    Optional<CourseDtoResponse> getCourseById(Long studentId);
    Optional<CourseDtoResponse> updateCourse(Long studentId, CourseDtoRequest studentDtoRequest);
    boolean deleteCourse(Long studentId);
}
