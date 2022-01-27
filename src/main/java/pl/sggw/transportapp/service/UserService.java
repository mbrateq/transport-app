package pl.sggw.transportapp.service;

import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsername(String username);

    User getUserByUsername(String username);

    User setStatus(long userId, boolean status);

    List<User> listUsers();

    boolean deleteUser(long userId);

    User addUser(CreateUserDto createUserDto);

}
