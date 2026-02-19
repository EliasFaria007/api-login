package api.login.controller;

import api.login.domain.User;
import api.login.dto.UserRequestDTO;
import api.login.dto.UserResponseDTO;
import api.login.mapper.UserMapper;
import api.login.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDTO create(@RequestBody @Valid UserRequestDTO dto) {
        User user = mapper.toEntity(dto);
        User saved = service.create(user);
        return mapper.toDTO(saved);
    }
}
