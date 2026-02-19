package api.login.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterResponse {
    private Long id;
    private String username;
    private String role;
}
