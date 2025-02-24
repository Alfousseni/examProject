package com.alf.labs.users_service.students.mapper;

import com.alf.labs.users_service.students.dto.requests.StudentDtoRequest;
import com.alf.labs.users_service.students.dto.responses.StudentDtoResponse;
import com.alf.labs.users_service.students.entities.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StudentMapper {
    //@Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "emailPro", target = "emailPro")
    @Mapping(source = "emailPerso", target = "emailPerso")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "address", target = "address")
    //@Mapping(source = "archive", target = "archive")
    @Mapping(source = "registrationNu", target = "registrationNu")
    StudentEntity toStudentEntity(StudentDtoRequest studentDtoRequest);
    StudentDtoResponse toStudentDtoResponse(StudentEntity studentEntity);
    List<StudentEntity> toStudentEntityList(List<StudentDtoRequest> studentDtoRequestList);
    List<StudentDtoResponse> toStudentDtoResponseList(List<StudentEntity> studentEntityList);
}
