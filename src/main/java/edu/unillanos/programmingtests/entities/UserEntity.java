package edu.unillanos.programmingtests.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "email_user")
    private String email;

    @Column(name = "password_user")
    private String password;

    @Column(name = "rol_user")
    private String rol;

}
