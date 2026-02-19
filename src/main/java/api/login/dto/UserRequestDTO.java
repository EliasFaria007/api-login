package api.login.dto;

import api.login.domain.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotNull
        Role role
) {}
