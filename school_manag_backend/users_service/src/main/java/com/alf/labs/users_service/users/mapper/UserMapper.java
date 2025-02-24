package com.alf.labs.users_service.users.mapper;

import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;
import com.alf.labs.users_service.users.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    //@Mapping(source = "id", target = "id")
    @Mapping(source = "emailPro", target = "emailPro")
    @Mapping(source = "token", target = "token")
    UserEntity toUserEntity(UserDtoRequest userDtoRequest);
    UserDtoResponse toUserDtoResponse(UserEntity userEntity);
    List<UserEntity> toUserEntityList(List<UserDtoRequest> userDtoRequestList);
    List<UserDtoResponse> toUserDtoResponseList(List<UserEntity> userEntityList);
}
