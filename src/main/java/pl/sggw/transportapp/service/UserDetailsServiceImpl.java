package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserDetailsServiceImpl
        implements UserDetailsService
{

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userService
        .findUserByUsername(username)
        .map(UserDetailsImpl::new)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
  }
}
