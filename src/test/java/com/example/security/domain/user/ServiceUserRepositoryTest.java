package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class ServiceUserRepositoryTest {

  @Autowired UserRepository userRepository;

  @Test
  void saveAndFindById() {
    ServiceUser serviceUser =
        userRepository.save(
            ServiceUser.builder().userId("test").password("test").userName("개발자").build());
    userRepository.save(
        ServiceUser.builder().userId("test1").password("test1").userName("개발자1").build());
    userRepository.save(
        ServiceUser.builder().userId("test2").password("test2").userName("개발자2").build());
    log.info("save : {}", serviceUser.toString());
    Optional<ServiceUser> userResult = userRepository.findByUserId(serviceUser.getUserId());
    log.info("findById : {} ", userResult.get());
    log.info("count : {} ", userRepository.count());

    log.info(
        "IdAndPassword : {} ",
        userRepository
            .findByUserIdAndPassword(serviceUser.getUserId(), serviceUser.getPassword())
            .get());

    Assertions.assertThat(serviceUser != null);
  }

  @Test
  void encrypt() {
    String rawPassword = "test1234";
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    log.debug("encode : {}", encoder.encode(rawPassword));
    Optional<ServiceUser> serviceUser = userRepository.findByUserId("test");
    if(serviceUser.isPresent()){
      log.debug("db passwd: {}", serviceUser.get().getPassword());
      log.debug("match : {}", encoder.matches(rawPassword, encoder.encode(rawPassword)));
      log.debug("db match : {}", encoder.matches(rawPassword, serviceUser.get().getPassword()));
    }
    log.debug("encode : {}", encoder.encode(rawPassword));
  }
}
