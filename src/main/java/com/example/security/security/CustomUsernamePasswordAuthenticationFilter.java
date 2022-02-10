package com.example.security.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
public class CustomUsernamePasswordAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
    setFilterProcessesUrl("/user/login-process");
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    log.debug("attemptAuthentication");

    if (!"POST".equals(request.getMethod())) {
      throw new AuthenticationServiceException("Method method support : " + request.getMethod());
    }

    //    String username = obtainUsername(request);
    //    String password = obtainPassword(request);
    String username = request.getParameter("userid");
    String password = request.getParameter("password");
    String secretNumber = request.getParameter("secret_number");
    CustomUsernamePasswordAuthenticationToken token =
        new CustomUsernamePasswordAuthenticationToken(username, password, secretNumber);

    return this.authenticationManager.authenticate(token);
  }
}
