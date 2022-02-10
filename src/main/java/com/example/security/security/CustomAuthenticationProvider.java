package com.example.security.security;

import com.example.security.domain.user.LoginUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

  final LoginUserDetailsServiceImpl loginUserDetailsService;
  final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    log.debug("authenticate : {}", authentication.getCredentials());

    CustomUsernamePasswordAuthenticationToken token =
        (CustomUsernamePasswordAuthenticationToken) authentication;

    UserDetails user = loginUserDetailsService.loadUserByUsername(token.getName());

    if (user == null) {
      throw new UsernameNotFoundException("Username not found!!");
    }

    if (!passwordEncoder.matches((String) token.getCredentials(), user.getPassword())) {
      throw new BadCredentialsException("password not match!!");
    }

    return new CustomUsernamePasswordAuthenticationToken(
        user, user.getPassword(), user.getAuthorities(), token.getSecretNumber());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return CustomUsernamePasswordAuthenticationToken.class.equals(authentication);
  }
}
