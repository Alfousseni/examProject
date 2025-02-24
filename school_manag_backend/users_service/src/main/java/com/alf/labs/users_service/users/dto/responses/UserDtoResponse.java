package com.alf.labs.users_service.users.dto.responses;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDtoResponse implements Serializable {
    private Long id;
    private String emailPro;
    private String token;
}
