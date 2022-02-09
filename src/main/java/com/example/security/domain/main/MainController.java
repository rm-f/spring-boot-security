package com.example.security.domain.main;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

  @RequestMapping({"/index", "/"})
  public String index(Model model) {
    return "main/index";
  }
}
