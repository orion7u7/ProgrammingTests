package edu.unillanos.programmingtests.repositories.impl;

import edu.unillanos.programmingtests.entities.UserEntity;
import edu.unillanos.programmingtests.models.User;
import edu.unillanos.programmingtests.repositories.jpa.UserRepositoryJpa;
import edu.unillanos.programmingtests.utils.Mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    public List<User> findAll() {
        return UserMapper.entityListToModelList(userRepositoryJpa.findAll());
    }

    public User findById(Long id) {
        return UserMapper.entityToModel(Objects.requireNonNull(userRepositoryJpa.findById(id).orElse(null)));
    }

    public User save(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setRol(user.getRol());

        return UserMapper.entityToModel(userRepositoryJpa.save(userEntity));
    }


}
