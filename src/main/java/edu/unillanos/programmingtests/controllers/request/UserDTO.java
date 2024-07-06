package edu.unillanos.programmingtests.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String rol;
}
