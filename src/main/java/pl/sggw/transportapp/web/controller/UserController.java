package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;
import pl.sggw.transportapp.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class UserController extends ControllerAbstract implements UserOperations {

  private final UserService userService;

  @Override
  @GetMapping(value = "/")
  public Page<User> listUsers(
      @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
      @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return userService.listUsers(preparePageRequest(page, pageSize));
  }

  @Override
  @DeleteMapping(value = "/{userId}")
  public Boolean deleteUser(@PathVariable long userId) {
    return userService.deleteUser(userId);
  }

  @Override
  @GetMapping(value = "/{userName}")
  public User getUser(@PathVariable String userName) {
    return userService.getUserByUsername(userName);
  }

  @Override
  @PutMapping(value = "/")
  public User addUser(@RequestBody CreateUserDto createUserDto) {
    return userService.addUser(createUserDto);
  }
}
