package com.example.security.security;

import com.example.security.domain.user.LoginUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

  final LoginUserDetailsServiceImpl loginUserDetailsService;


  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    log.debug("authenticate : {}", authentication.getCredentials());


    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }
}
