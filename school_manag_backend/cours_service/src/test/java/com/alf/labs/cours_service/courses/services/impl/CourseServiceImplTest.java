package com.alf.labs.cours_service.courses.services.impl;

import com.alf.labs.cours_service.exception.EntityExistsException;
import com.alf.labs.cours_service.exception.EntityNotFoundException;
import com.alf.labs.cours_service.courses.dto.requests.CourseDtoRequest;
import com.alf.labs.cours_service.courses.dto.responses.CourseDtoResponse;
import com.alf.labs.cours_service.courses.entities.CourseEntity;
import com.alf.labs.cours_service.courses.mapper.CourseMapper;
import com.alf.labs.cours_service.courses.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private CourseServiceImpl courseService;
    @Mock
    private CourseMapper courseMapper;
    @Mock
    private MessageSource messageSource;

    @Test
    void saveCourseOK() {
        when(courseRepository.findByName(anyString())).thenReturn(Optional.empty());
        when(courseMapper.toCourseEntity(any())).thenReturn(getCourseEntity());
        when(courseRepository.save(any())).thenReturn(getCourseEntity());
        when(courseMapper.toCourseDtoResponse(any())).thenReturn(getCourseDtoResponse());

        Optional<CourseDtoResponse> courseDtoResponse = courseService.saveCourse(getCourseDtoRequest());
        assertTrue(courseDtoResponse.isPresent());
    }

    @Test
    void saveCourseKO() {
        when(courseRepository.findByName(anyString())).thenReturn(Optional.of(getCourseEntity()));
        when(messageSource.getMessage(eq("course.exists"), any(), any(Locale.class))).thenReturn("the course with name = jee is already created");

        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> courseService.saveCourse(getCourseDtoRequest()));
        assertEquals("the course with name = jee is already created", exception.getMessage());
        assertNotNull(exception);
    }

    @Test
    void getAllCourses() {
        when(courseRepository.findAll()).thenReturn(List.of(getCourseEntity()));
        when(courseMapper.toCourseDtoResponseList(any())).thenReturn(List.of(getCourseDtoResponse()));

        Optional<List<CourseDtoResponse>> courses = courseService.getAllCourses();
        assertTrue(courses.isPresent());
        assertEquals(1, courses.get().size());
    }

    @Test
    void getCourseByIdOK() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(getCourseEntity()));
        when(courseMapper.toCourseDtoResponse(any())).thenReturn(getCourseDtoResponse());

        Optional<CourseDtoResponse> course = courseService.getCourseById(1L);
        assertTrue(course.isPresent());
        assertEquals(1L, course.get().getId());
    }

    @Test
    void getCourseByIdKO() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("course.notfound"), any(), any(Locale.class))).thenReturn("Course with id=1 is not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> courseService.getCourseById(1L));
        assertEquals("Course with id=1 is not found", exception.getMessage());
    }

    @Test
    void updateCourseOK() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(getCourseEntity()));
        when(courseRepository.save(any())).thenReturn(getCourseEntity());
        when(courseMapper.toCourseDtoResponse(any())).thenReturn(getCourseDtoResponse());

        Optional<CourseDtoResponse> updatedCourse = courseService.updateCourse(1L, getCourseDtoRequest());
        assertTrue(updatedCourse.isPresent());
        assertEquals(1L, updatedCourse.get().getId());
    }

    @Test
    void updateCourseKO() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("course.notfound"), any(), any(Locale.class)))
                .thenReturn("Course not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> courseService.updateCourse(1L ,getCourseDtoRequest()));
        assertEquals("Course not found", exception.getMessage());
    }

    @Test
    void deleteCourseOK() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(getCourseEntity()));
        boolean result = courseService.deleteCourse(anyLong());
        assertTrue(result);
        verify(courseRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteCourseKO() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("course.notfound"), any(), any(Locale.class)))
                .thenReturn("Course not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> courseService.deleteCourse(1L));
        assertEquals("Course not found", exception.getMessage());
    }

    private CourseDtoRequest getCourseDtoRequest(){
        CourseDtoRequest courseDtoRequest = new CourseDtoRequest();
        courseDtoRequest.setName("jee");
        courseDtoRequest.setDescription("Java Enterprise Edition");
        return courseDtoRequest;
    }
    private CourseEntity getCourseEntity(){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        courseEntity.setName("jee");
        courseEntity.setDescription("Java Enterprise Edition");
        return courseEntity;
    }
    private CourseDtoResponse getCourseDtoResponse(){
        CourseDtoResponse courseDtoResponse = new CourseDtoResponse();
        courseDtoResponse.setId(1L);
        courseDtoResponse.setName("jee");
        courseDtoResponse.setDescription("Java Enterprise Edition");
        return courseDtoResponse;
    }

}
