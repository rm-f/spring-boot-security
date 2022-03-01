package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import com.example.security.domain.user.form.RegistForm;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserApiController {

  final UserService userService;

  @GetMapping("/{no}")
  public ResponseEntity<ServiceUser> serviceUserByNo(@PathVariable("no") Long no) {
    return ResponseEntity.ok(userService.getServiceUser(no));
  }

  @PostMapping("/regist")
  public ResponseEntity<ServiceUser> regist(@Valid RegistForm registForm) {
    return ResponseEntity.ok(userService.regist(registForm));
  }
}
