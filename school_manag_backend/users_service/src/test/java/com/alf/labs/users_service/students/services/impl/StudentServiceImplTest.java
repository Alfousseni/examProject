package com.alf.labs.users_service.students.services.impl;

import com.alf.labs.users_service.exception.EntityExistsException;
import com.alf.labs.users_service.exception.EntityNotFoundException;
import com.alf.labs.users_service.students.dto.requests.StudentDtoRequest;
import com.alf.labs.users_service.students.dto.responses.StudentDtoResponse;
import com.alf.labs.users_service.students.entities.StudentEntity;
import com.alf.labs.users_service.students.mapper.StudentMapper;
import com.alf.labs.users_service.students.repository.StudentRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private MessageSource messageSource;


    @Test
    void saveStudentOK() {
        when(studentRepository.findByEmailPerso(anyString())).thenReturn(Optional.empty());
        when(studentMapper.toStudentEntity(any())).thenReturn(getStudentEntity());
        when(studentRepository.save(any())).thenReturn(getStudentEntity());
        when(studentMapper.toStudentDtoResponse(any())).thenReturn(getStudentDtoResponse());

        Optional<StudentDtoResponse> studentDtoResponse = studentService.saveStudent(getStudentDtoRequest());
        assertTrue(studentDtoResponse.isPresent());
    }

    @Test
    void saveStudentKO() {
        when(studentRepository.findByEmailPerso(anyString())).thenReturn(Optional.of(getStudentEntity()));
        when(messageSource.getMessage(eq("student.exists"), any(), any(Locale.class))).thenReturn("The student with emailPerso = coulybaly.alf@gmail.com is already created");

        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> studentService.saveStudent(getStudentDtoRequest()));
        assertEquals("The student with emailPerso = coulybaly.alf@gmail.com  is already created", exception.getMessage());
        assertNotNull(exception);
    }

    @Test
    void getAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(getStudentEntity()));
        when(studentMapper.toStudentDtoResponseList(any())).thenReturn(List.of(getStudentDtoResponse()));

        Optional<List<StudentDtoResponse>> students = studentService.getAllStudents();
        assertTrue(students.isPresent());
        assertEquals(1, students.get().size());
    }

    @Test
    void getStudentByIdOK() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(getStudentEntity()));
        when(studentMapper.toStudentDtoResponse(any())).thenReturn(getStudentDtoResponse());

        Optional<StudentDtoResponse> student = studentService.getStudentById(1L);
        assertTrue(student.isPresent());
        assertEquals(1L, student.get().getId());
    }

    @Test
    void getStudentByIdKO() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("student.notfound"), any(), any(Locale.class))).thenReturn("Requested student with id = 1 does not exist");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> studentService.getStudentById(1L));
        assertEquals("Requested student with id = 1 does not exist", exception.getMessage());
    }

    @Test
    void updateStudentOK() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(getStudentEntity()));
        when(studentRepository.save(any())).thenReturn(getStudentEntity());
        when(studentMapper.toStudentDtoResponse(any())).thenReturn(getStudentDtoResponse());

        Optional<StudentDtoResponse> updatedStudent = studentService.updateStudent(1L, getStudentDtoRequest());
        assertTrue(updatedStudent.isPresent());
        assertEquals(1L, updatedStudent.get().getId());
    }

    @Test
    void updateStudentKO() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("student.notfound"), any(), any(Locale.class)))
                .thenReturn("Requested student with id = 1 does not exist");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> studentService.updateStudent(1L ,getStudentDtoRequest()));
        assertEquals("Requested student with id = 1 does not exist", exception.getMessage());
    }

    @Test
    void deleteStudentOK() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(getStudentEntity()));
        boolean result = studentService.deleteStudent(anyLong());
        assertTrue(result);
        verify(studentRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteStudentKO() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("student.notfound"), any(), any(Locale.class)))
                .thenReturn("Requested student with id = 1 does not exist");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> studentService.deleteStudent(1L));
        assertEquals("Requested student with id = 1 does not exist", exception.getMessage());
    }


    private StudentDtoRequest getStudentDtoRequest(){
        StudentDtoRequest studentDtoRequest = new StudentDtoRequest();
        studentDtoRequest.setFirstName("Kangni");
        studentDtoRequest.setLastName("alfousseni");
        studentDtoRequest.setEmailPerso("alfousseni@gmail.com");
        studentDtoRequest.setEmailPro("alfousseni@groupeisi.com");
        studentDtoRequest.setAddress("Dakar");
        studentDtoRequest.setPhoneNumber("1234567890");
        studentDtoRequest.setRegistrationNu("1234");
        return studentDtoRequest;
    }
    private StudentEntity getStudentEntity(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setFirstName("Kangni");
        studentEntity.setLastName("alfousseni");
        studentEntity.setEmailPerso("alfousseni@gmail.com");
        studentEntity.setEmailPro("alfousseni@groupeisi.com");
        studentEntity.setAddress("Dakar");
        studentEntity.setPhoneNumber("1234567890");
        studentEntity.setRegistrationNu("1234");
        studentEntity.setArchive(false);
        return studentEntity;
    }
    private StudentDtoResponse getStudentDtoResponse(){
        StudentDtoResponse studentDtoResponse = new StudentDtoResponse();
        studentDtoResponse.setId(1L);
        studentDtoResponse.setFirstName("Kangni");
        studentDtoResponse.setLastName("alfousseni");
        studentDtoResponse.setEmailPerso("alfousseni@gmail.com");
        studentDtoResponse.setEmailPro("alfousseni@groupeisi.com");
        studentDtoResponse.setAddress("Dakar");
        studentDtoResponse.setPhoneNumber("1234567890");
        studentDtoResponse.setRegistrationNu("1234");
        studentDtoResponse.setArchive(false);
        return studentDtoResponse;
    }


}
