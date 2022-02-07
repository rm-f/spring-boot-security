package com.example.security.domain.user;

import com.example.security.domain.mapper.LoginUserMapper;
import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
//@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {

  final UserRepository userRepository;
  final LoginUserMapper loginUserMapper;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Optional<ServiceUser> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("Could not find user");
    }
    return loginUserMapper.toDto(user.get());
  }
}
