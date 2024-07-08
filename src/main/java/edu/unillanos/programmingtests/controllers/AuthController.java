package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.models.User;
import edu.unillanos.programmingtests.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return authService.authenticate(username, password);
    }
}
