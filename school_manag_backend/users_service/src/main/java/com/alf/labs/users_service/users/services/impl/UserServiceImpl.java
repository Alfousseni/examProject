package com.alf.labs.users_service.users.services.impl;

import com.alf.labs.users_service.exception.EntityExistsException;
import com.alf.labs.users_service.exception.EntityNotFoundException;
import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;
import com.alf.labs.users_service.users.entities.UserEntity;
import com.alf.labs.users_service.users.mapper.UserMapper;
import com.alf.labs.users_service.users.repository.UserRepository;
import com.alf.labs.users_service.users.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageSource messageSource;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Optional<UserDtoResponse> saveUser(UserDtoRequest userDtoRequest){
        if (userRepository.findByEmailPro(userDtoRequest.getEmailPro()).isPresent()) {
            throw new EntityExistsException(messageSource.getMessage("user.exists", new Object[]{userDtoRequest.getEmailPro()}, Locale.getDefault()));
        }
        UserEntity user = userMapper.toUserEntity(userDtoRequest);
        logger.info("EmailPro: {}", user);
        UserEntity userEntity = userRepository.save(user);
        UserDtoResponse userDtoResponse = userMapper.toUserDtoResponse(userEntity);
        return Optional.of(userDtoResponse);
    }
    @Override
    public Optional<List<UserDtoResponse>> getAllUsers(){
        List<UserEntity> userEntities = userRepository.findAll();
        return Optional.of(userMapper.toUserDtoResponseList(userEntities));
    }
    @Override
    public Optional<UserDtoResponse> getUserById(Long userId){
        return userRepository.findById(userId)
                .map(user -> Optional.of(userMapper.toUserDtoResponse(user)))
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{userId}, Locale.getDefault())));
    }
    @Override
    public Optional<UserDtoResponse> updateUser(Long userId, UserDtoRequest userDtoRequest){
        return userRepository.findById(userId)
                .map(user -> {
                    user.setEmailPro(userDtoRequest.getEmailPro());
                    user.setToken(userDtoRequest.getToken());
                    var userEntity = userRepository.save(user);
                    return Optional.of(userMapper.toUserDtoResponse(userEntity));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{userId}, Locale.getDefault())));
    }
    @Override
    public boolean deleteUser(Long userId){
        if (userRepository.findById(userId).isEmpty()) {
            throw new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{userId}, Locale.getDefault()));
        }
        userRepository.deleteById(userId);
        return true;
    }
}
