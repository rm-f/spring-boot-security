package com.example.security.domain.user;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.security.domain.user.entity.User;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  void saveAndFindById() {
    User user =
        userRepository.save(User.builder().id("test").password("test").name("개발자").build());
    userRepository.save(User.builder().id("test1").password("test1").name("개발자1").build());
    userRepository.save(User.builder().id("test2").password("test2").name("개발자2").build());
    log.info("save : {}", user.toString());
    Optional<User> userResult = userRepository.findById(user.getId());
    log.info("findById : {} ", userResult.get().toString());
    log.info("count : {} ", userRepository.count());

    log.info("IdAndPassword : {} ", userRepository.findByIdAndPassword(user.getId(), user.getPassword()).get().toString());

    Assertions.assertThat(user != null);
  }
}
