package api.login.dto;

import api.login.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public record UserResponseDTO(
        Long id,
        String username,
        Role role
) {}
