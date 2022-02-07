package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ServiceUserRepositoryTest {

  @Autowired UserRepository userRepository;

  @Test
  void saveAndFindById() {
    ServiceUser serviceUser =
        userRepository.save(ServiceUser.builder().id("test").password("test").name("개발자").build());
    userRepository.save(ServiceUser.builder().id("test1").password("test1").name("개발자1").build());
    userRepository.save(ServiceUser.builder().id("test2").password("test2").name("개발자2").build());
    log.info("save : {}", serviceUser.toString());
    Optional<ServiceUser> userResult = userRepository.findById(serviceUser.getId());
    log.info("findById : {} ", userResult.get().toString());
    log.info("count : {} ", userRepository.count());

    log.info(
        "IdAndPassword : {} ",
        userRepository
            .findByIdAndPassword(serviceUser.getId(), serviceUser.getPassword())
            .get()
            .toString());

    Assertions.assertThat(serviceUser != null);
  }
}
