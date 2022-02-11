package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Arrays;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Slf4j
@ToString
@Getter
@Setter
public class LoginUser extends User {

  private static final long serialVersionUID = 5981165430449248911L;

  private ServiceUser serviceUser;

  public LoginUser(
      String userId, String password, Collection<? extends GrantedAuthority> authorities) {
    super(userId, password, authorities);
  }

  public LoginUser(ServiceUser serviceUser) {
    super(
        serviceUser.getUserId(),
        serviceUser.getPassword(),
        Arrays.asList(new SimpleGrantedAuthority(serviceUser.getUserRole())));
  }
}
