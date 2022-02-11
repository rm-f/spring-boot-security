package com.example.security.security;

import java.util.Collection;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

@Getter
public final class CustomUsernamePasswordAuthenticationToken
    extends UsernamePasswordAuthenticationToken {

  private static final long serialVersionUID = -343503744765173849L;
  private final String secretNumber;

  public CustomUsernamePasswordAuthenticationToken(
      Object principal, Object credentials, String secretNumber) {
    super(principal, credentials);
    this.secretNumber = secretNumber;
  }

  public CustomUsernamePasswordAuthenticationToken(
      Object principal,
      Object credentials,
      Collection<? extends GrantedAuthority> authorities,
      String secretNumber) {
    super(principal, credentials, authorities);
    this.secretNumber = secretNumber;
  }
}
