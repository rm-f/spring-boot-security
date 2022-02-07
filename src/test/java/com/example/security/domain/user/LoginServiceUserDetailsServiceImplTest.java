package com.example.security.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

@Slf4j
@SpringBootTest
class LoginServiceUserDetailsServiceImplTest {

  @Autowired
  UserDetailsService userDetailsService;

}
