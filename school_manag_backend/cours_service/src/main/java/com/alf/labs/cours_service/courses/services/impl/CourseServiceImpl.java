package com.alf.labs.cours_service.courses.services.impl;

import com.alf.labs.cours_service.courses.services.ICourseService;
import com.alf.labs.cours_service.exception.EntityExistsException;
import com.alf.labs.cours_service.exception.EntityNotFoundException;
import com.alf.labs.cours_service.courses.dto.requests.CourseDtoRequest;
import com.alf.labs.cours_service.courses.dto.responses.CourseDtoResponse;
import com.alf.labs.cours_service.courses.entities.CourseEntity;
import com.alf.labs.cours_service.courses.mapper.CourseMapper;
import com.alf.labs.cours_service.courses.repository.CourseRepository;
import com.alf.labs.cours_service.courses.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final MessageSource messageSource;
    private final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Override
    public Optional<CourseDtoResponse> saveCourse(CourseDtoRequest courseDtoRequest){
        if (courseRepository.findByName(courseDtoRequest.getName()).isPresent()) {
            throw new EntityExistsException(messageSource.getMessage("course.exists", new Object[]{courseDtoRequest.getName()}, Locale.getDefault()));
        }
        CourseEntity course = courseMapper.toCourseEntity(courseDtoRequest);
        logger.info("Cours: {}", course);
        CourseEntity courseEntity = courseRepository.save(course);
        CourseDtoResponse courseDtoResponse = courseMapper.toCourseDtoResponse(courseEntity);
        return Optional.of(courseDtoResponse);
    }
    @Override
    public Optional<List<CourseDtoResponse>> getAllCourses(){
        List<CourseEntity> coursesEntities = courseRepository.findAll();
        return Optional.of(courseMapper.toCourseDtoResponseList(coursesEntities));
    }
    @Override
    public Optional<CourseDtoResponse> getCourseById(Long id){
        return courseRepository.findById(id)
                .map(user -> Optional.of(courseMapper.toCourseDtoResponse(user)))
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("course.notfound", new Object[]{id}, Locale.getDefault())));
    }
    @Override
    public Optional<CourseDtoResponse> updateCourse(Long id, CourseDtoRequest courseDtoRequest){
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(courseDtoRequest.getName());
                    course.setDescription(courseDtoRequest.getDescription());
                    var courseEntity = courseRepository.save(course);
                    return Optional.of(courseMapper.toCourseDtoResponse(courseEntity));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("course.notfound", new Object[]{id}, Locale.getDefault())));
    }
    @Override
    public boolean deleteCourse(Long id){
        if (courseRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(messageSource.getMessage("course.notfound", new Object[]{id}, Locale.getDefault()));
        }
        courseRepository.deleteById(id);
        return true;
    }
}
