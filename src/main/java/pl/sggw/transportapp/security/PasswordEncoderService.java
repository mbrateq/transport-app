package pl.sggw.transportapp.security;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Getter
@Service
public class PasswordEncoderService {
  private final PasswordEncoder passwordEncoder;

  public PasswordEncoderService() {
//    this.passwordEncoder = NoOpPasswordEncoder.getInstance();
            this.passwordEncoder = new BCryptPasswordEncoder();
  }
}
