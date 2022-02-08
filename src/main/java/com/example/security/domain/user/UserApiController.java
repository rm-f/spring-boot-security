package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserApiController {

  final UserService userService;

  @GetMapping("/{no}")
  public ServiceUser serviceUserByNo(@PathVariable("no") Long no) {
    return userService.getServiceUser(no);
  }
}
