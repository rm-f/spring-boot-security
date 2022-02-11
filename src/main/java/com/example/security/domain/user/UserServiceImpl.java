package com.example.security.domain.user;

import com.example.security.domain.mapper.RegistFormToServiceUserMapper;
import com.example.security.domain.user.entity.ServiceUser;
import com.example.security.domain.user.form.RegistForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  final PasswordEncoder passwordEncoder;
  final UserRepository userRepository;
  final RegistFormToServiceUserMapper registFormToServiceUserMapper;

  @Override
  public ServiceUser regist(final RegistForm registForm) {
    String encodedPassword = passwordEncoder.encode(registForm.getPassword());
    ServiceUser serviceUser = registFormToServiceUserMapper.toEntity(registForm);
    serviceUser.setPassword(encodedPassword);
    return userRepository.save(serviceUser);
  }

  @Override
  public ServiceUser getServiceUser(final long userNo) {
    return userRepository
        .findByUserNo(userNo)
        .orElseThrow(() -> new RuntimeException("Not found user!!"));
  }
}
