package com.alf.labs.users_service.users.controller;


import com.alf.labs.users_service.users.dto.requests.UserDtoRequest;
import com.alf.labs.users_service.users.dto.responses.UserDtoResponse;
import com.alf.labs.users_service.users.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(value = "http://localhost:4200")
@RequiredArgsConstructor
@Getter
@Setter
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        List<UserDtoResponse> users = userService.getAllUsers().get();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUser(@PathVariable("id") Long id){
        Optional<UserDtoResponse> user = userService.getUserById(id);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> saveUser(@RequestBody @Valid UserDtoRequest userDtoRequest){
        Optional<UserDtoResponse> userDtoResponse = userService.saveUser(userDtoRequest);
        return new ResponseEntity<>(userDtoResponse.get(), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDtoRequest userDtoRequest){
        Optional<UserDtoResponse> userDtoResponse = userService.updateUser(id, userDtoRequest);
        return new ResponseEntity<>(userDtoResponse.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        boolean result = userService.deleteUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
