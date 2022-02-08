package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Arrays;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

  private static final long serialVersionUID = 5981165430449248911L;

  private ServiceUser serviceUser;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(serviceUser.getUserRole());
    return Arrays.asList(authority);
  }

  @Override
  public String getPassword() {
    return serviceUser.getPassword();
  }

  @Override
  public String getUsername() {
    return serviceUser.getUserId();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return serviceUser.isEnabled();
  }
}
