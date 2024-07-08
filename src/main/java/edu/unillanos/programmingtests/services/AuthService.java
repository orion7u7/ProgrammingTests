package edu.unillanos.programmingtests.services;

import edu.unillanos.programmingtests.models.User;
import edu.unillanos.programmingtests.repositories.impl.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        Optional<User> usuario = Optional.ofNullable(userRepository.findByEmail(email));
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
