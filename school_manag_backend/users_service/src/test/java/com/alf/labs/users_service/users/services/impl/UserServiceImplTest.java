package com.alf.labs.users_service.users.services.impl;

import com.alf.labs.users_service.exception.EntityExistsException;
import com.alf.labs.users_service.exception.EntityNotFoundException;
import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;
import com.alf.labs.users_service.users.entities.UserEntity;
import com.alf.labs.users_service.users.mapper.UserMapper;
import com.alf.labs.users_service.users.repository.UserRepository;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private MessageSource messageSource;

    @Test
    void saveUserOK() {
        when(userRepository.findByEmailPro(anyString())).thenReturn(Optional.empty());
        when(userMapper.toUserEntity(any())).thenReturn(getUserEntity());
        when(userRepository.save(any())).thenReturn(getUserEntity());
        when(userMapper.toUserDtoResponse(any())).thenReturn(getUserDtoResponse());

        Optional<UserDtoResponse> userDtoResponse = userService.saveUser(getUserDtoRequest());
        assertTrue(userDtoResponse.isPresent());
    }

    @Test
    void saveUserKO() {
        when(userRepository.findByEmailPro(anyString())).thenReturn(Optional.of(getUserEntity()));
        when(messageSource.getMessage(eq("user.exists"), any(), any(Locale.class))).thenReturn("the user with email = alfousseni@gmail.com is already created");

        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> userService.saveUser(getUserDtoRequest()));
        assertEquals("the user with email = alfousseni@gmail.com is already created", exception.getMessage());
        assertNotNull(exception);
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(getUserEntity()));
        when(userMapper.toUserDtoResponseList(any())).thenReturn(List.of(getUserDtoResponse()));

        Optional<List<UserDtoResponse>> users = userService.getAllUsers();
        assertTrue(users.isPresent());
        assertEquals(1, users.get().size());
    }

    @Test
    void getUserByIdOK() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(getUserEntity()));
        when(userMapper.toUserDtoResponse(any())).thenReturn(getUserDtoResponse());

        Optional<UserDtoResponse> user = userService.getUserById(1L);
        assertTrue(user.isPresent());
        assertEquals(1L, user.get().getId());
    }

    @Test
    void getUserByIdKO() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("user.notfound"), any(), any(Locale.class))).thenReturn("User with id=1 is not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.getUserById(1L));
        assertEquals("User with id=1 is not found", exception.getMessage());
    }

    @Test
    void updateUserOK() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(getUserEntity()));
        when(userRepository.save(any())).thenReturn(getUserEntity());
        when(userMapper.toUserDtoResponse(any())).thenReturn(getUserDtoResponse());

        Optional<UserDtoResponse> updatedUser = userService.updateUser(1L, getUserDtoRequest());
        assertTrue(updatedUser.isPresent());
        assertEquals(1L, updatedUser.get().getId());
    }

    @Test
    void updateUserKO() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("user.notfound"), any(), any(Locale.class)))
                .thenReturn("User not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.updateUser(1L ,getUserDtoRequest()));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void deleteUserOK() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(getUserEntity()));
        boolean result = userService.deleteUser(anyLong());
        assertTrue(result);
        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteUserKO() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("user.notfound"), any(), any(Locale.class)))
                .thenReturn("User not found");

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.deleteUser(1L));
        assertEquals("User not found", exception.getMessage());
    }

    private UserDtoRequest getUserDtoRequest(){
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setEmailPro("alfousseni@gmail.com");
        userDtoRequest.setToken("1xji_BS2Bnxbuz62");
        return userDtoRequest;
    }
    private UserEntity getUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmailPro("alfousseni@gmail.com");
        userEntity.setToken("1xji_BS2Bnxbuz62");
        return userEntity;
    }
    private UserDtoResponse getUserDtoResponse(){
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setId(1L);
        userDtoResponse.setEmailPro("alfousseni@gmail.com");
        userDtoResponse.setToken("1xji_BS2Bnxbuz62");
        return userDtoResponse;
    }

}
