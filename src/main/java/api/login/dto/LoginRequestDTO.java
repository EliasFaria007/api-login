package api.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public record LoginRequestDTO(
        @NotBlank
        String username,
        @NotBlank
        String password
) {}
