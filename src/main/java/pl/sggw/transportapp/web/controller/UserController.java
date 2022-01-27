package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;
import pl.sggw.transportapp.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PutMapping(value = "/{userId}")
  public User setStatus(@PathVariable long userId, @RequestBody boolean status) {
    return userService.setStatus(userId, status);
  }

  @GetMapping(value = "/")
  public List<User> listUsers() {
    return userService.listUsers();
  }

  @DeleteMapping(value = "/{userId}")
  public Boolean deleteUser(@PathVariable long userId) {
    return userService.deleteUser(userId);
  }

  @GetMapping(value = "/{userName}")
  public User getUser(@PathVariable String userName) {
    return userService.getUserByUsername(userName);
  }

  @PutMapping(value = "/")
  public User addUser(@RequestBody CreateUserDto createUserDto) {
    return userService.addUser(createUserDto);
  }
}
