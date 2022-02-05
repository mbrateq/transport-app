package pl.sggw.transportapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsername(String username);

    User getUserByUsername(String username);

    User setStatus(long userId, boolean status);

    Page<User> listUsers(Pageable pageable);

    boolean deleteUser(long userId);

    User addUser(CreateUserDto createUserDto);

}
