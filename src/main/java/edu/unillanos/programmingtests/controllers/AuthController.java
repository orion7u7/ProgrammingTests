package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public HttpStatus login(@RequestParam String username, @RequestParam String password) {
        return authService.authenticate(username, password) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
    }
}
