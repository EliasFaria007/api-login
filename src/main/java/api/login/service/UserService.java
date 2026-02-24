package api.login.service;

import api.login.domain.User;
import api.login.exception.BusinessException;
import api.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User create(User user) {

        if (repository.existsByUsername(user.getUsername())) {
            throw new BusinessException("Username já existe");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
