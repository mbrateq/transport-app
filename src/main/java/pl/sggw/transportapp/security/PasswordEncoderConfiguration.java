package pl.sggw.transportapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class PasswordEncoderConfiguration{

  private final PasswordEncoderService passwordEncoderService;


  @Bean(name = "passwordEncoder")
  public PasswordEncoder getPasswordEncoder() {
    return passwordEncoderService.getPasswordEncoder();
  }
}
