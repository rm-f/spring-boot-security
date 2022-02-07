package com.example.security.domain.user;

import com.example.security.domain.mapper.LoginUserMapper;
import com.example.security.domain.user.entity.ServiceUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  final UserRepository userRepository;
  final LoginUserMapper loginUserMapper;

  @Override
  public ServiceUser regist(LoginUser loginUser) {
    return userRepository.save(loginUserMapper.toEntity(loginUser));
  }
}
