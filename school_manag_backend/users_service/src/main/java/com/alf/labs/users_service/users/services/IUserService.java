package com.alf.labs.users_service.users.services;

import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDtoResponse> saveUser(UserDtoRequest userDtoRequest);
    Optional<List<UserDtoResponse>> getAllUsers();
    Optional<UserDtoResponse> getUserById(Long userId);
    Optional<UserDtoResponse> updateUser(Long userId, UserDtoRequest userDtoRequest);
    boolean deleteUser(Long userId);
}
