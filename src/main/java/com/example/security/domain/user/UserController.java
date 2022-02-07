package com.example.security.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
class UserController {

  @GetMapping("/login")
  public String login(String error, String logout, Model model) {

    if (error != null) {
      model.addAttribute("error", "Login error!");
    }

    if(logout != null){
      model.addAttribute("logout", "Logout!!");
    }

    return "user/login";
  }

  @GetMapping("/login-error")
  public String loginError(String error, String logout, Model model){
    if (error != null) {
      model.addAttribute("error", "Login error!");
    }

    if(logout != null){
      model.addAttribute("logout", "Logout!!");
    }
    return "user/login-error";
  }
}
