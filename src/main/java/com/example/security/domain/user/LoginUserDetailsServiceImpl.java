package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {

  final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Optional<ServiceUser> serviceUser = userRepository.findByUserId(userId);
    if (serviceUser.isEmpty()) {
      throw new UsernameNotFoundException("Could not find user");
    }
    LoginUser loginUser = new LoginUser(serviceUser.get());
    log.debug("serviceUser : {}", serviceUser);
    log.debug("loginUser : {}", loginUser);
    return loginUser;
  }
}
