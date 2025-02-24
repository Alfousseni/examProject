package com.alf.labs.users_service.students.services.impl;

import com.alf.labs.users_service.exception.EntityExistsException;
import com.alf.labs.users_service.exception.EntityNotFoundException;
import com.alf.labs.users_service.students.dto.requests.StudentDtoRequest;
import com.alf.labs.users_service.students.dto.responses.StudentDtoResponse;
import com.alf.labs.users_service.students.entities.StudentEntity;
import com.alf.labs.users_service.students.mapper.StudentMapper;
import com.alf.labs.users_service.students.repository.StudentRepository;
import com.alf.labs.users_service.students.services.IStudentService;
import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;
import com.alf.labs.users_service.users.entities.UserEntity;
import com.alf.labs.users_service.users.mapper.UserMapper;
import com.alf.labs.users_service.users.repository.UserRepository;
import com.alf.labs.users_service.users.services.impl.UserServiceImpl;
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
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final MessageSource messageSource;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Optional<StudentDtoResponse> saveStudent(StudentDtoRequest studentDtoRequest){
        if (studentRepository.findByEmailPerso(studentDtoRequest.getEmailPerso()).isPresent()) {
            throw new EntityExistsException(messageSource.getMessage("student.exists", new Object[]{studentDtoRequest.getEmailPro()}, Locale.getDefault()));
        }
        StudentEntity student = studentMapper.toStudentEntity(studentDtoRequest);
        logger.info("EmailPro: {}", student);
        StudentEntity studentEntity = studentRepository.save(student);
        StudentDtoResponse studentDtoResponse = studentMapper.toStudentDtoResponse(studentEntity);
        return Optional.of(studentDtoResponse);
    }
    @Override
    public Optional<List<StudentDtoResponse>> getAllStudents(){
        List<StudentEntity> studentsEntities = studentRepository.findAll();
        return Optional.of(studentMapper.toStudentDtoResponseList(studentsEntities));
    }
    @Override
    public Optional<StudentDtoResponse> getStudentById(Long id){
        return studentRepository.findById(id)
                .map(user -> Optional.of(studentMapper.toStudentDtoResponse(user)))
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("student.notfound", new Object[]{id}, Locale.getDefault())));
    }
    @Override
    public Optional<StudentDtoResponse> updateStudent(Long id, StudentDtoRequest studentDtoRequest){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setEmailPro(studentDtoRequest.getEmailPro());
                    student.setEmailPerso(studentDtoRequest.getEmailPerso());
                    var studentEntity = studentRepository.save(student);
                    return Optional.of(studentMapper.toStudentDtoResponse(studentEntity));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("student.notfound", new Object[]{id}, Locale.getDefault())));
    }
    @Override
    public boolean deleteStudent(Long id){
        if (studentRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(messageSource.getMessage("student.notfound", new Object[]{id}, Locale.getDefault()));
        }
        studentRepository.deleteById(id);
        return true;
    }
}
