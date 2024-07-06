package edu.unillanos.programmingtests.controllers;

import edu.unillanos.programmingtests.controllers.request.UserDTO;
import edu.unillanos.programmingtests.controllers.responses.CustomResponse;
import edu.unillanos.programmingtests.services.UserService;
import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import edu.unillanos.programmingtests.utils.Mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final GenericMapper genericMapper;

    @GetMapping
    public CustomResponse<List> findAll() {
        return new CustomResponse<>(genericMapper.mapList(userService.findAll(), UserDTO.class), HttpStatus.OK, "Users found successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<UserDTO> findById(Long id) {
        return new CustomResponse<>(genericMapper.map(userService.findById(id), UserDTO.class), HttpStatus.OK, "User found successfully");
    }

    @PostMapping("/create")
    public CustomResponse<UserDTO> save(UserDTO user) {
        return new CustomResponse<>(genericMapper.map(userService.save(UserMapper.dtoToModel(user)), UserDTO.class), HttpStatus.OK, "User created successfully");
    }

}
