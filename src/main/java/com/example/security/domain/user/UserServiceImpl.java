package com.example.security.domain.user;

import com.example.security.domain.mapper.RegistFormToServiceUserMapper;
import com.example.security.domain.user.entity.ServiceUser;
import com.example.security.domain.user.form.RegistForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  final UserRepository userRepository;
  final RegistFormToServiceUserMapper registFormToServiceUserMapper;

  @Override
  public ServiceUser regist(RegistForm registForm) {
    return userRepository.save(registFormToServiceUserMapper.toEntity(registForm));
  }

  @Override
  public ServiceUser getServiceUser(long userNo) {
    return userRepository
        .findByUserNo(userNo)
        .orElseThrow(() -> new RuntimeException("Not found user!!"));
  }
}
