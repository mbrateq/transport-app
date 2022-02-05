package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;
import pl.sggw.transportapp.model.repository.UserRepository;
import pl.sggw.transportapp.security.PasswordEncoderService;

import javax.validation.ValidationException;
import java.nio.CharBuffer;
import java.util.ConcurrentModificationException;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoderService passwordEncoderService;

  @Override
  public Optional<User> findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public User getUserByUsername(String username) {
    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new ValidationException(format("User with username %s not found.", username)));
  }

  @Override
  public User setStatus(long userId, boolean status) {
    User toUpdate = userRepository.findById(userId).get();
    if (toUpdate.getEnabled() == status) {
      throw new ConcurrentModificationException("Entity already modified");
    }
    return userRepository.save(toUpdate.toBuilder().enabled(status).build());
  }

  @Override
  public Page<User> listUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public boolean deleteUser(long userId) {
    boolean deleted = false;
    if (userRepository.findById(userId).isPresent()) {
      userRepository.deleteById(userId);
      deleted = true;
    }
    return deleted;
  }

  @Override
  public User addUser(CreateUserDto createUserDto) {
    return userRepository.save(
        User.builder()
            .username(createUserDto.getUsername())
            .password(
                passwordEncoderService
                    .getPasswordEncoder()
                    .encode(CharBuffer.wrap(createUserDto.getPassword())))
                .enabled(true)
            .build());
//    TODO remove password
  }
}
