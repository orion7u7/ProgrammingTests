package edu.unillanos.programmingtests.utils.Mappers;

import edu.unillanos.programmingtests.controllers.request.UserDTO;
import edu.unillanos.programmingtests.entities.UserEntity;
import edu.unillanos.programmingtests.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<User> entityListToModelList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(UserMapper::entityToModel).collect(Collectors.toList());
    }

    public static User entityToModel(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getRol());
    }

    public static UserEntity modelToEntity(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRol());
    }

    public static User dtoToModel(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRol());
    }
}
