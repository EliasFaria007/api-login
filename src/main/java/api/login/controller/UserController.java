package api.login.controller;

import api.login.domain.User;
import api.login.dto.UserRequestDTO;
import api.login.dto.UserResponseDTO;
import api.login.mapper.UserMapper;
import api.login.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService Service, UserMapper Mapper) {
        this.service = Service;
        this.mapper = Mapper;
    }
    @PostMapping
    public UserResponseDTO create(@RequestBody UserRequestDTO dto) {
        User user = mapper.toEntity(dto);
        User saved = service.save(user);
        return mapper.toDTO(saved);
    }
}
